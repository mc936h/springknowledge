package io.springknowledge.context;

import io.springknowledge.model.KnowledgeUnit;
import java.util.List;

public interface ContextAssembler {

    String assemble(String query, List<KnowledgeUnit> units);

}