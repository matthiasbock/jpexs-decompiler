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
package com.jpexs.decompiler.flash.action.treemodel.clauses;

import com.jpexs.decompiler.flash.action.Action;
import com.jpexs.decompiler.flash.action.treemodel.ConstantPool;
import com.jpexs.decompiler.flash.action.treemodel.ContinueTreeItem;
import com.jpexs.decompiler.flash.action.treemodel.TreeItem;
import java.util.ArrayList;
import java.util.List;

public class WhileTreeItem extends LoopTreeItem implements Block {

   public TreeItem expression;
   public List<TreeItem> commands;

   public WhileTreeItem(Action instruction, long loopBreak, long loopContinue, TreeItem expression, List<TreeItem> commands) {
      super(instruction, loopBreak, loopContinue);
      this.expression = expression;
      this.commands = commands;

      if ((!commands.isEmpty()) && (commands.get(commands.size() - 1) instanceof ContinueTreeItem)) {
         if (((ContinueTreeItem) commands.get(commands.size() - 1)).loopPos == loopBreak) {
            commands.remove(commands.size() - 1);
         }
      }
   }

   @Override
   public String toString(ConstantPool constants) {
      String ret = "";
      ret += "loop" + loopBreak + ":\r\n";
      ret += hilight("while(") + expression.toString(constants) + hilight(")") + "\r\n{\r\n";
      for (TreeItem ti : commands) {
         ret += ti.toString(constants) + "\r\n";
      }
      ret += hilight("}") + "\r\n";
      ret += ":loop" + loopBreak;
      return ret;
   }

   public List<ContinueTreeItem> getContinues() {
      List<ContinueTreeItem> ret = new ArrayList<ContinueTreeItem>();
      for (TreeItem ti : commands) {
         if (ti instanceof ContinueTreeItem) {
            ret.add((ContinueTreeItem) ti);
         }
         if (ti instanceof Block) {
            ret.addAll(((Block) ti).getContinues());
         }
      }
      return ret;
   }
}