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
package com.jpexs.asdec.action.treemodel;

import com.jpexs.asdec.action.Action;
import com.jpexs.asdec.action.treemodel.ConstantPool;
import com.jpexs.asdec.action.treemodel.TreeItem;
import java.util.HashMap; import java.util.List;

public class MBStringLengthTreeItem extends TreeItem {

   public TreeItem value;

   public MBStringLengthTreeItem(Action instruction, TreeItem value) {
      super(instruction, PRECEDENCE_PRIMARY);
      this.value = value;
   }

   @Override
   public String toString(ConstantPool constants) {
      String s = value.toString(constants);
      if (value.precedence > precedence) {
         s = "(" + s + ")";
      }
      return hilight("mblength(") + s + ")";
   }
   
   @Override
    public List<com.jpexs.asdec.action.IgnoredPair> getNeededActions() {
      List<com.jpexs.asdec.action.IgnoredPair> ret=super.getNeededActions();
      ret.addAll(value.getNeededActions());
      return ret;
   }
}