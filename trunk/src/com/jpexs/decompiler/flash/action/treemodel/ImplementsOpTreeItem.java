/*
 *  Copyright (C) 2010-2013 JPEXS
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
package com.jpexs.decompiler.flash.action.treemodel;

import com.jpexs.decompiler.flash.action.Action;
import java.util.List;

public class ImplementsOpTreeItem extends TreeItem {

   public TreeItem subclass;
   public List<TreeItem> superclasses;

   public ImplementsOpTreeItem(Action instruction, TreeItem subclass, List<TreeItem> superclasses) {
      super(instruction, PRECEDENCE_PRIMARY);
      this.subclass = subclass;
      this.superclasses = superclasses;
   }

   @Override
   public String toString(ConstantPool constants) {
      String impStr = "";
      for (int i = 0; i < superclasses.size(); i++) {
         if (i > 0) {
            impStr += ",";
         }
         impStr += superclasses.get(i).toString(constants);
      }
      return subclass.toString(constants) + hilight(" implements ") + impStr;
   }

   @Override
   public List<com.jpexs.decompiler.flash.action.IgnoredPair> getNeededActions() {
      List<com.jpexs.decompiler.flash.action.IgnoredPair> ret = super.getNeededActions();
      ret.addAll(subclass.getNeededActions());
      for (TreeItem ti : superclasses) {
         ret.addAll(ti.getNeededActions());
      }
      return ret;
   }
}