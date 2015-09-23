package com.dnfeitosa.codegraph.db.graph.converters;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConverter {

	private static final Logger LOGGER = Logger.getLogger(ApplicationConverter.class);

	private final ModuleConverter moduleConverter;

	@Autowired
	public ApplicationConverter(ModuleConverter moduleConverter) {
		this.moduleConverter = moduleConverter;
	}

	public com.dnfeitosa.codegraph.core.model.Application fromNode(com.dnfeitosa.codegraph.db.graph.nodes.Application node) {
		LOGGER.trace(String.format("Converting node to application '%s'.", node.getName()));

		List<com.dnfeitosa.codegraph.core.model.Module> modules = moduleConverter.fromNodes(node.getModules());
		return new com.dnfeitosa.codegraph.core.model.Application(node.getName(), modules);
	}

	public com.dnfeitosa.codegraph.db.graph.nodes.Application toNode(com.dnfeitosa.codegraph.core.model.Application application) {
		com.dnfeitosa.codegraph.db.graph.nodes.Application node = new com.dnfeitosa.codegraph.db.graph.nodes.Application();
		node.setName(application.getName());
		node.setModules(toNodes(application.getModules()));
		return node;
	}

	private Set<com.dnfeitosa.codegraph.db.graph.nodes.Module> toNodes(Collection<com.dnfeitosa.codegraph.core.model.Module> modules) {
		return moduleConverter.toNodes(modules);
	}
}