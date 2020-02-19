package co.ariskycode.graphql.model;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class GraphQLObject {

	private List<Map> list;
	private Speaker speaker;
}
