package com.jpexs.decompiler.graph.model;

import com.jpexs.decompiler.graph.GraphSourceItem;
import com.jpexs.decompiler.graph.GraphTargetItem;
import com.jpexs.decompiler.graph.SourceGenerator;
import java.util.List;

/**
 *
 * @author JPEXS
 */
public class ContinueItem extends GraphTargetItem {

    public long loopId;

    public ContinueItem(GraphSourceItem src, long loopId) {
        super(src, NOPRECEDENCE);
        this.loopId = loopId;
    }

    @Override
    public String toString(List<Object> localData) {
        return hilight("continue") + " " + "loop" + loopId;
    }

    @Override
    public List<GraphSourceItem> toSource(List<Object> localData, SourceGenerator generator) {
        return generator.generate(localData, this);
    }

    @Override
    public boolean hasReturnValue() {
        return false;
    }
}