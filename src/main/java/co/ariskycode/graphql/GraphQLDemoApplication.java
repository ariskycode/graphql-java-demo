package co.ariskycode.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.coxautodev.graphql.tools.SchemaParser;

import co.ariskycode.graphql.resolver.Mutation;
import co.ariskycode.graphql.resolver.Query;
import co.ariskycode.graphql.resolver.TalkResolver;
import co.ariskycode.graphql.service.AttendeeService;
import co.ariskycode.graphql.service.SpeakerService;
import co.ariskycode.graphql.service.TalkService;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLHttpServlet;

@SpringBootApplication
public class GraphQLDemoApplication {

	@Autowired
	private SpeakerService speakerService;

	@Autowired
	private TalkService talkService;

	@Autowired
	private AttendeeService attendeeService;

	public static void main(String[] args) {
		SpringApplication.run(GraphQLDemoApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean graphQLServlet() {
		return new ServletRegistrationBean(SimpleGraphQLHttpServlet.newBuilder(buildSchema(speakerService, attendeeService, talkService)).build(), "/graphql");
	}

	private static GraphQLSchema buildSchema(SpeakerService speakerService, AttendeeService attendeeService, TalkService talkService) {
		return SchemaParser.newParser()
				.file("graphql/schema.graphqls")
				.resolvers(new Query(attendeeService, speakerService, talkService), new TalkResolver(speakerService), new Mutation(speakerService, talkService))
				.build()
				.makeExecutableSchema();
	}
}
