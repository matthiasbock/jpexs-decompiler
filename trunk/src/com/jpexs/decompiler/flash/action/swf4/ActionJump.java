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
package com.jpexs.decompiler.flash.action.swf4;

import com.jpexs.decompiler.flash.SWFInputStream;
import com.jpexs.decompiler.flash.SWFOutputStream;
import com.jpexs.decompiler.flash.action.Action;
import com.jpexs.decompiler.flash.action.parser.FlasmLexer;
import com.jpexs.decompiler.flash.action.parser.ParseException;
import com.jpexs.decompiler.flash.helpers.Helper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActionJump extends Action {

   public int offset;
   public String identifier;

   public ActionJump(int offset) {
      super(0x99, 2);
      this.offset = offset;
   }

   public ActionJump(SWFInputStream sis) throws IOException {
      super(0x99, 2);
      offset = sis.readSI16();
   }

   @Override
   public List<Long> getAllRefs(int version) {
      List<Long> ret = new ArrayList<Long>();
      ret.add(getRef(version));
      return ret;
   }

   public long getRef(int version) {
      return getAddress() + getBytes(version).length + offset;
   }

   @Override
   public byte[] getBytes(int version) {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      SWFOutputStream sos = new SWFOutputStream(baos, version);
      try {
         sos.writeSI16(offset);
         sos.close();
      } catch (IOException e) {
      }
      return surroundWithAction(baos.toByteArray(), version);
   }

   @Override
   public String getASMSource(List<Long> knownAddreses, List<String> constantPool, int version) {
      return "Jump loc" + Helper.formatAddress(getAddress() + getBytes(version).length + offset);
   }

   public ActionJump(FlasmLexer lexer) throws IOException, ParseException {
      super(0x99, 0);
      identifier = lexIdentifier(lexer);
   }

   @Override
   public List<Action> getAllIfsOrJumps() {
      List<Action> ret = new ArrayList<Action>();
      ret.add(this);
      return ret;
   }

   @Override
   public String toString() {
      return "Jump";
   }
}