/*
 *  Copyright (C) 2010-2014 JPEXS
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jpexs.decompiler.flash.gui.dumpview;

import com.jpexs.decompiler.flash.SWF;
import com.jpexs.decompiler.flash.dumpview.DumpInfo;
import com.jpexs.decompiler.flash.treeitems.SWFList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author JPEXS
 */
public class DumpTreeModel implements TreeModel {

    private final DumpInfo root;

    public DumpTreeModel(List<SWFList> swfs) {
        DumpInfo root = new DumpInfo("root", "", null, 0, 0);
        for (SWFList swfList : swfs) {
            for (SWF swf : swfList) {
                swf.dumpInfo.name = swf.getFileTitle();
                root.getChildInfos().add(swf.dumpInfo);
            }
        }
        this.root = root;
    }

    private List<DumpInfo> searchDumpInfo(DumpInfo dumpInfo, DumpInfo parent, List<DumpInfo> path) {
        List<DumpInfo> ret = null;
        int cnt = getChildCount(parent);
        for (int i = 0; i < cnt; i++) {
            DumpInfo n = getChild(parent, i);
            List<DumpInfo> newPath = new ArrayList<>();
            newPath.addAll(path);
            newPath.add(n);

            if (dumpInfo == n) {
                return newPath;
            }

            ret = searchDumpInfo(dumpInfo, n, newPath);
            if (ret != null) {
                return ret;
            }
        }
        return ret;
    }

    public TreePath getDumpInfoPath(DumpInfo dumpInfo) {
        List<DumpInfo> path = new ArrayList<>();
        path.add(getRoot());
        path = searchDumpInfo(dumpInfo, getRoot(), path);
        if (path == null) {
            return null;
        }
        TreePath tp = new TreePath(path.toArray(new Object[path.size()]));
        return tp;
    }

    @Override
    public DumpInfo getRoot() {
        return root;
    }

    @Override
    public DumpInfo getChild(Object o, int i) {
        return ((DumpInfo) o).getChildInfos().get(i);
    }

    @Override
    public int getChildCount(Object o) {
        return ((DumpInfo) o).getChildCount();
    }

    @Override
    public boolean isLeaf(Object o) {
        return ((DumpInfo) o).getChildCount() == 0;
    }

    @Override
    public void valueForPathChanged(TreePath tp, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIndexOfChild(Object o, Object o1) {
        return ((DumpInfo) o).getChildInfos().indexOf(o1);
    }

    @Override
    public void addTreeModelListener(TreeModelListener tl) {
    }

    @Override
    public void removeTreeModelListener(TreeModelListener tl) {
    }

}
