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
package com.jpexs.decompiler.flash.abc.avm2.parser;

/**
 * This class is a scanner generated by <a href="http://www.jflex.de/">JFlex</a>
 * 1.4.3 on 19.9.10 10:36 from the specification file
 * <tt>D:/Dokumenty/Programovani/JavaSE/ASDec/trunk/src/com/jpexs/decompiler/flash/abc/avm2/parser/flasm3.flex</tt>
 */
public final class Flasm3Lexer {

   /**
    * This character denotes the end of file
    */
   public static final int YYEOF = -1;
   /**
    * initial size of the lookahead buffer
    */
   private static final int ZZ_BUFFERSIZE = 16384;
   /**
    * lexical states
    */
   public static final int STRING = 2;
   public static final int YYINITIAL = 0;
   public static final int PARAMETERS = 4;
   /**
    * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
    * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l at the
    * beginning of a line l is of the form l = 2*k, k a non negative integer
    */
   private static final int ZZ_LEXSTATE[] = {
      0, 0, 1, 1, 2, 2
   };
   /**
    * Translates characters to character classes
    */
   private static final String ZZ_CMAP_PACKED =
           "\11\12\1\4\1\2\1\0\1\4\1\1\16\12\4\0\1\40\1\0"
           + "\1\43\1\0\1\11\2\0\1\46\3\0\1\23\1\0\1\17\1\20"
           + "\1\0\1\16\3\47\4\24\2\7\1\15\1\3\5\0\4\11\1\21"
           + "\25\11\1\6\1\25\1\10\1\0\1\14\1\0\1\36\1\44\1\27"
           + "\1\41\1\22\1\45\1\42\1\13\1\32\3\13\1\5\1\34\1\33"
           + "\1\30\1\13\1\37\1\35\1\31\3\13\1\26\2\13\4\0\41\12"
           + "\2\0\4\11\4\0\1\11\2\0\1\12\7\0\1\11\4\0\1\11"
           + "\5\0\27\11\1\0\37\11\1\0\u013f\11\31\0\162\11\4\0\14\11"
           + "\16\0\5\11\11\0\1\11\21\0\130\12\5\0\23\12\12\0\1\11"
           + "\13\0\1\11\1\0\3\11\1\0\1\11\1\0\24\11\1\0\54\11"
           + "\1\0\46\11\1\0\5\11\4\0\202\11\1\0\4\12\3\0\105\11"
           + "\1\0\46\11\2\0\2\11\6\0\20\11\41\0\46\11\2\0\1\11"
           + "\7\0\47\11\11\0\21\12\1\0\27\12\1\0\3\12\1\0\1\12"
           + "\1\0\2\12\1\0\1\12\13\0\33\11\5\0\3\11\15\0\4\12"
           + "\14\0\6\12\13\0\32\11\5\0\13\11\16\12\7\0\12\12\4\0"
           + "\2\11\1\12\143\11\1\0\1\11\10\12\1\0\6\12\2\11\2\12"
           + "\1\0\4\12\2\11\12\12\3\11\2\0\1\11\17\0\1\12\1\11"
           + "\1\12\36\11\33\12\2\0\3\11\60\0\46\11\13\12\1\11\u014f\0"
           + "\3\12\66\11\2\0\1\12\1\11\20\12\2\0\1\11\4\12\3\0"
           + "\12\11\2\12\2\0\12\12\21\0\3\12\1\0\10\11\2\0\2\11"
           + "\2\0\26\11\1\0\7\11\1\0\1\11\3\0\4\11\2\0\1\12"
           + "\1\11\7\12\2\0\2\12\2\0\3\12\11\0\1\12\4\0\2\11"
           + "\1\0\3\11\2\12\2\0\12\12\4\11\15\0\3\12\1\0\6\11"
           + "\4\0\2\11\2\0\26\11\1\0\7\11\1\0\2\11\1\0\2\11"
           + "\1\0\2\11\2\0\1\12\1\0\5\12\4\0\2\12\2\0\3\12"
           + "\13\0\4\11\1\0\1\11\7\0\14\12\3\11\14\0\3\12\1\0"
           + "\11\11\1\0\3\11\1\0\26\11\1\0\7\11\1\0\2\11\1\0"
           + "\5\11\2\0\1\12\1\11\10\12\1\0\3\12\1\0\3\12\2\0"
           + "\1\11\17\0\2\11\2\12\2\0\12\12\1\0\1\11\17\0\3\12"
           + "\1\0\10\11\2\0\2\11\2\0\26\11\1\0\7\11\1\0\2\11"
           + "\1\0\5\11\2\0\1\12\1\11\6\12\3\0\2\12\2\0\3\12"
           + "\10\0\2\12\4\0\2\11\1\0\3\11\4\0\12\12\1\0\1\11"
           + "\20\0\1\12\1\11\1\0\6\11\3\0\3\11\1\0\4\11\3\0"
           + "\2\11\1\0\1\11\1\0\2\11\3\0\2\11\3\0\3\11\3\0"
           + "\10\11\1\0\3\11\4\0\5\12\3\0\3\12\1\0\4\12\11\0"
           + "\1\12\17\0\11\12\11\0\1\11\7\0\3\12\1\0\10\11\1\0"
           + "\3\11\1\0\27\11\1\0\12\11\1\0\5\11\4\0\7\12\1\0"
           + "\3\12\1\0\4\12\7\0\2\12\11\0\2\11\4\0\12\12\22\0"
           + "\2\12\1\0\10\11\1\0\3\11\1\0\27\11\1\0\12\11\1\0"
           + "\5\11\2\0\1\12\1\11\7\12\1\0\3\12\1\0\4\12\7\0"
           + "\2\12\7\0\1\11\1\0\2\11\4\0\12\12\22\0\2\12\1\0"
           + "\10\11\1\0\3\11\1\0\27\11\1\0\20\11\4\0\6\12\2\0"
           + "\3\12\1\0\4\12\11\0\1\12\10\0\2\11\4\0\12\12\22\0"
           + "\2\12\1\0\22\11\3\0\30\11\1\0\11\11\1\0\1\11\2\0"
           + "\7\11\3\0\1\12\4\0\6\12\1\0\1\12\1\0\10\12\22\0"
           + "\2\12\15\0\60\11\1\12\2\11\7\12\4\0\10\11\10\12\1\0"
           + "\12\12\47\0\2\11\1\0\1\11\2\0\2\11\1\0\1\11\2\0"
           + "\1\11\6\0\4\11\1\0\7\11\1\0\3\11\1\0\1\11\1\0"
           + "\1\11\2\0\2\11\1\0\4\11\1\12\2\11\6\12\1\0\2\12"
           + "\1\11\2\0\5\11\1\0\1\11\1\0\6\12\2\0\12\12\2\0"
           + "\2\11\42\0\1\11\27\0\2\12\6\0\12\12\13\0\1\12\1\0"
           + "\1\12\1\0\1\12\4\0\2\12\10\11\1\0\42\11\6\0\24\12"
           + "\1\0\2\12\4\11\4\0\10\12\1\0\44\12\11\0\1\12\71\0"
           + "\42\11\1\0\5\11\1\0\2\11\1\0\7\12\3\0\4\12\6\0"
           + "\12\12\6\0\6\11\4\12\106\0\46\11\12\0\51\11\7\0\132\11"
           + "\5\0\104\11\5\0\122\11\6\0\7\11\1\0\77\11\1\0\1\11"
           + "\1\0\4\11\2\0\7\11\1\0\1\11\1\0\4\11\2\0\47\11"
           + "\1\0\1\11\1\0\4\11\2\0\37\11\1\0\1\11\1\0\4\11"
           + "\2\0\7\11\1\0\1\11\1\0\4\11\2\0\7\11\1\0\7\11"
           + "\1\0\27\11\1\0\37\11\1\0\1\11\1\0\4\11\2\0\7\11"
           + "\1\0\47\11\1\0\23\11\16\0\11\12\56\0\125\11\14\0\u026c\11"
           + "\2\0\10\11\12\0\32\11\5\0\113\11\3\0\3\11\17\0\15\11"
           + "\1\0\4\11\3\12\13\0\22\11\3\12\13\0\22\11\2\12\14\0"
           + "\15\11\1\0\3\11\1\0\2\12\14\0\64\11\40\12\3\0\1\11"
           + "\3\0\2\11\1\12\2\0\12\12\41\0\3\12\2\0\12\12\6\0"
           + "\130\11\10\0\51\11\1\12\126\0\35\11\3\0\14\12\4\0\14\12"
           + "\12\0\12\12\36\11\2\0\5\11\u038b\0\154\11\224\0\234\11\4\0"
           + "\132\11\6\0\26\11\2\0\6\11\2\0\46\11\2\0\6\11\2\0"
           + "\10\11\1\0\1\11\1\0\1\11\1\0\1\11\1\0\37\11\2\0"
           + "\65\11\1\0\7\11\1\0\1\11\3\0\3\11\1\0\7\11\3\0"
           + "\4\11\2\0\6\11\4\0\15\11\5\0\3\11\1\0\7\11\17\0"
           + "\4\12\32\0\5\12\20\0\2\11\23\0\1\11\13\0\4\12\6\0"
           + "\6\12\1\0\1\11\15\0\1\11\40\0\22\11\36\0\15\12\4\0"
           + "\1\12\3\0\6\12\27\0\1\11\4\0\1\11\2\0\12\11\1\0"
           + "\1\11\3\0\5\11\6\0\1\11\1\0\1\11\1\0\1\11\1\0"
           + "\4\11\1\0\3\11\1\0\7\11\3\0\3\11\5\0\5\11\26\0"
           + "\44\11\u0e81\0\3\11\31\0\11\11\6\12\1\0\5\11\2\0\5\11"
           + "\4\0\126\11\2\0\2\12\2\0\3\11\1\0\137\11\5\0\50\11"
           + "\4\0\136\11\21\0\30\11\70\0\20\11\u0200\0\u19b6\11\112\0\u51a6\11"
           + "\132\0\u048d\11\u0773\0\u2ba4\11\u215c\0\u012e\11\2\0\73\11\225\0\7\11"
           + "\14\0\5\11\5\0\1\11\1\12\12\11\1\0\15\11\1\0\5\11"
           + "\1\0\1\11\1\0\2\11\1\0\2\11\1\0\154\11\41\0\u016b\11"
           + "\22\0\100\11\2\0\66\11\50\0\15\11\3\0\20\12\20\0\4\12"
           + "\17\0\2\11\30\0\3\11\31\0\1\11\6\0\5\11\1\0\207\11"
           + "\2\0\1\12\4\0\1\11\13\0\12\12\7\0\32\11\4\0\1\11"
           + "\1\0\32\11\12\0\132\11\3\0\6\11\2\0\6\11\2\0\6\11"
           + "\2\0\3\11\3\0\2\11\3\0\2\11\22\0\3\12\4\0";
   /**
    * Translates characters to character classes
    */
   private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);
   /**
    * Translates DFA states to action switch labels.
    */
   private static final int[] ZZ_ACTION = zzUnpackAction();
   private static final String ZZ_ACTION_PACKED_0 =
           "\3\0\2\1\1\2\1\1\1\2\1\3\2\4\1\1"
           + "\1\5\2\6\1\7\1\10\1\11\1\10\1\11\2\1"
           + "\1\12\1\0\1\13\1\2\1\14\2\15\1\16\1\17"
           + "\1\20\1\21\1\22\1\23\1\24\1\25\1\0\1\26"
           + "\1\0\1\26\1\0\1\2\1\15\1\0\1\26\1\0"
           + "\1\2\1\0\1\2\1\27\15\2\1\0\2\2\2\0"
           + "\2\2\1\30\1\2\6\0\1\31\1\32";

   private static int[] zzUnpackAction() {
      int[] result = new int[81];
      int offset = 0;
      offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
      return result;
   }

   private static int zzUnpackAction(String packed, int offset, int[] result) {
      int i = 0;       /* index in packed string  */
      int j = offset;  /* index in unpacked array */
      int l = packed.length();
      while (i < l) {
         int count = packed.charAt(i++);
         int value = packed.charAt(i++);
         do {
            result[j++] = value;
         } while (--count > 0);
      }
      return j;
   }
   /**
    * Translates a state to a row index in the transition table
    */
   private static final int[] ZZ_ROWMAP = zzUnpackRowMap();
   private static final String ZZ_ROWMAP_PACKED_0 =
           "\0\0\0\50\0\120\0\170\0\240\0\310\0\360\0\u0118"
           + "\0\u0140\0\u0168\0\170\0\u0190\0\170\0\u01b8\0\170\0\u01e0"
           + "\0\u0208\0\u0230\0\u0258\0\u0280\0\u02a8\0\u02d0\0\170\0\360"
           + "\0\170\0\u02f8\0\170\0\u0320\0\u0348\0\170\0\170\0\170"
           + "\0\170\0\170\0\170\0\170\0\170\0\u0370\0\u0398\0\u03c0"
           + "\0\u0280\0\u02d0\0\u03e8\0\170\0\u0410\0\u0438\0\u0438\0\u0460"
           + "\0\u0488\0\u04b0\0\170\0\u04d8\0\u0500\0\u0528\0\u0550\0\u0578"
           + "\0\u05a0\0\u05c8\0\u05f0\0\u0618\0\u0640\0\u0668\0\u0690\0\u06b8"
           + "\0\u06e0\0\u0708\0\u0730\0\u0758\0\u0780\0\u07a8\0\u07d0\0\170"
           + "\0\u07f8\0\u0820\0\u0848\0\u0870\0\u0898\0\u08c0\0\u08e8\0\170"
           + "\0\170";

   private static int[] zzUnpackRowMap() {
      int[] result = new int[81];
      int offset = 0;
      offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
      return result;
   }

   private static int zzUnpackRowMap(String packed, int offset, int[] result) {
      int i = 0;  /* index in packed string  */
      int j = offset;  /* index in unpacked array */
      int l = packed.length();
      while (i < l) {
         int high = packed.charAt(i++) << 16;
         result[j++] = high | packed.charAt(i++);
      }
      return j;
   }
   /**
    * The transition table of the DFA
    */
   private static final int[] ZZ_TRANS = zzUnpackTrans();
   private static final String ZZ_TRANS_PACKED_0 =
           "\4\4\1\5\1\6\3\4\1\7\1\4\1\6\1\7"
           + "\4\4\1\7\1\10\3\4\12\6\1\5\2\6\1\4"
           + "\2\6\2\4\1\11\1\12\1\13\22\11\1\14\15\11"
           + "\1\15\4\11\1\4\1\16\1\17\1\20\1\4\1\21"
           + "\1\4\1\22\1\4\1\23\1\4\2\23\1\4\1\24"
           + "\1\25\1\26\2\23\1\4\1\22\1\4\12\23\1\4"
           + "\2\23\1\27\2\23\1\4\1\22\54\0\1\5\33\0"
           + "\1\5\14\0\1\6\1\0\1\6\1\0\2\30\2\6"
           + "\1\31\1\6\2\0\1\30\1\6\1\0\1\6\1\0"
           + "\12\6\1\0\2\6\1\0\2\6\1\0\1\6\5\0"
           + "\1\30\1\0\1\30\1\0\4\30\1\31\1\30\2\0"
           + "\2\30\1\0\1\30\1\0\12\30\1\0\2\30\1\0"
           + "\2\30\1\0\1\30\5\0\1\6\1\0\1\6\1\0"
           + "\2\30\2\6\1\31\1\6\2\0\1\30\1\6\1\0"
           + "\1\6\1\0\1\32\11\6\1\0\2\6\1\0\2\6"
           + "\1\0\1\6\1\11\2\0\22\11\1\0\15\11\1\0"
           + "\4\11\2\0\1\13\45\0\2\33\1\0\13\33\1\34"
           + "\5\33\1\35\1\36\3\33\1\37\2\33\1\40\2\33"
           + "\1\41\3\33\1\42\1\43\1\44\1\45\1\34\2\0"
           + "\1\17\45\0\1\20\2\0\45\20\5\0\1\23\1\46"
           + "\1\23\1\0\4\23\1\0\1\23\2\0\2\23\1\0"
           + "\1\23\1\0\12\23\1\0\2\23\1\0\2\23\1\0"
           + "\1\23\7\0\1\22\6\0\1\22\1\0\1\47\2\50"
           + "\1\0\1\22\22\0\1\22\5\0\1\23\1\0\1\23"
           + "\1\0\4\23\1\0\1\23\2\0\2\23\1\0\1\23"
           + "\1\0\12\23\1\0\2\23\1\0\2\23\1\0\1\23"
           + "\7\0\1\51\6\0\1\51\1\0\1\47\2\50\1\0"
           + "\1\51\22\0\1\51\7\0\1\22\6\0\1\51\1\0"
           + "\1\52\3\0\1\22\22\0\1\22\7\0\1\47\6\0"
           + "\1\47\5\0\1\47\22\0\1\47\5\0\1\6\1\0"
           + "\1\6\1\0\2\30\2\6\1\31\1\6\2\0\1\30"
           + "\1\6\1\0\1\6\1\0\1\6\1\53\10\6\1\0"
           + "\2\6\1\0\2\6\1\0\1\6\16\0\1\35\5\0"
           + "\1\35\22\0\1\35\16\0\1\54\5\0\1\54\22\0"
           + "\1\54\7\0\1\55\6\0\1\55\5\0\1\55\22\0"
           + "\1\55\7\0\1\47\6\0\1\47\2\0\2\50\1\0"
           + "\1\47\22\0\1\47\7\0\1\56\6\0\1\56\1\57"
           + "\3\0\1\57\1\56\22\0\1\56\5\0\1\6\1\0"
           + "\1\6\1\0\2\30\2\6\1\31\1\6\2\0\1\30"
           + "\1\60\1\0\1\6\1\0\12\6\1\0\2\6\1\0"
           + "\2\6\1\0\1\6\7\0\1\55\1\61\5\0\1\55"
           + "\5\0\1\55\22\0\1\55\7\0\1\56\6\0\1\56"
           + "\5\0\1\56\22\0\1\56\5\0\1\6\1\0\1\6"
           + "\1\0\2\30\2\6\1\31\1\6\2\0\1\30\1\6"
           + "\1\0\1\6\1\0\2\6\1\62\7\6\1\0\2\6"
           + "\1\0\2\6\1\0\1\6\43\0\1\63\11\0\1\6"
           + "\1\0\1\6\1\0\2\30\2\6\1\31\1\6\2\0"
           + "\1\30\1\6\1\0\1\6\1\0\3\6\1\64\6\6"
           + "\1\0\2\6\1\0\2\6\1\0\1\6\5\0\1\6"
           + "\1\0\1\6\1\0\2\30\2\6\1\31\1\6\2\0"
           + "\1\30\1\6\1\0\1\6\1\0\4\6\1\65\5\6"
           + "\1\0\2\6\1\0\2\6\1\0\1\6\5\0\1\6"
           + "\1\0\1\6\1\0\2\30\2\6\1\31\1\6\2\0"
           + "\1\30\1\6\1\0\1\6\1\0\5\6\1\66\4\6"
           + "\1\0\2\6\1\0\2\6\1\0\1\6\5\0\1\6"
           + "\1\0\1\6\1\0\2\30\2\6\1\31\1\6\2\0"
           + "\1\30\1\6\1\0\1\6\1\0\6\6\1\67\3\6"
           + "\1\0\2\6\1\0\2\6\1\0\1\6\5\0\1\6"
           + "\1\0\1\6\1\0\2\30\2\6\1\31\1\6\2\0"
           + "\1\30\1\70\1\0\1\6\1\0\3\6\1\71\3\6"
           + "\1\72\2\6\1\0\2\6\1\0\2\6\1\0\1\6"
           + "\5\0\1\6\1\0\1\6\1\0\2\30\2\6\1\31"
           + "\1\6\2\0\1\30\1\6\1\0\1\6\1\0\6\6"
           + "\1\73\3\6\1\0\2\6\1\0\2\6\1\0\1\6"
           + "\5\0\1\6\1\0\1\6\1\0\2\30\2\6\1\31"
           + "\1\6\2\0\1\30\1\6\1\0\1\6\1\0\10\6"
           + "\1\74\1\6\1\0\2\6\1\0\2\6\1\0\1\6"
           + "\5\0\1\6\1\0\1\6\1\0\2\30\2\6\1\31"
           + "\1\6\2\0\1\30\1\6\1\0\1\6\1\0\3\6"
           + "\1\75\6\6\1\0\2\6\1\0\2\6\1\0\1\6"
           + "\5\0\1\6\1\0\1\6\1\0\2\30\2\6\1\31"
           + "\1\6\2\0\1\30\1\6\1\0\1\6\1\0\12\6"
           + "\1\0\1\76\1\6\1\0\2\6\1\0\1\6\5\0"
           + "\1\6\1\0\1\6\1\0\2\30\2\6\1\31\1\6"
           + "\2\0\1\30\1\6\1\0\1\6\1\0\11\6\1\77"
           + "\1\0\2\6\1\0\2\6\1\0\1\6\5\0\1\6"
           + "\1\0\1\6\1\0\2\30\2\6\1\31\1\6\2\0"
           + "\1\30\1\6\1\0\1\6\1\0\10\6\1\100\1\6"
           + "\1\0\2\6\1\0\2\6\1\0\1\6\5\0\1\6"
           + "\1\0\1\6\1\0\2\30\2\6\1\31\1\6\2\0"
           + "\1\30\1\6\1\0\1\6\1\0\12\6\1\101\2\6"
           + "\1\0\2\6\1\0\1\6\5\0\1\6\1\0\1\6"
           + "\1\0\2\30\2\6\1\31\1\6\2\0\1\30\1\6"
           + "\1\0\1\6\1\0\12\6\1\0\1\6\1\102\1\0"
           + "\2\6\1\0\1\6\5\0\1\6\1\0\1\6\1\0"
           + "\2\30\2\6\1\31\1\6\2\0\1\30\1\6\1\0"
           + "\1\6\1\0\11\6\1\103\1\0\2\6\1\0\2\6"
           + "\1\0\1\6\7\0\1\104\6\0\1\105\5\0\1\104"
           + "\22\0\1\104\5\0\1\6\1\0\1\6\1\0\2\30"
           + "\2\6\1\31\1\6\2\0\1\30\1\106\1\0\1\6"
           + "\1\0\12\6\1\0\2\6\1\0\2\6\1\0\1\6"
           + "\5\0\1\6\1\0\1\6\1\0\2\30\2\6\1\31"
           + "\1\6\2\0\1\30\1\6\1\0\1\6\1\0\3\6"
           + "\1\107\6\6\1\0\2\6\1\0\2\6\1\0\1\6"
           + "\7\0\1\104\5\0\1\110\1\104\5\0\1\104\22\0"
           + "\1\104\15\0\1\110\37\0\1\6\1\0\1\6\1\0"
           + "\2\30\2\6\1\31\1\6\2\0\1\30\1\6\1\0"
           + "\1\6\1\0\3\6\1\111\6\6\1\0\2\6\1\0"
           + "\2\6\1\0\1\6\5\0\1\6\1\0\1\6\1\0"
           + "\2\30\2\6\1\31\1\6\2\0\1\30\1\6\1\0"
           + "\1\6\1\0\12\6\1\112\2\6\1\0\2\6\1\0"
           + "\1\6\5\0\1\6\1\0\1\6\1\0\2\30\2\6"
           + "\1\31\1\6\2\0\1\30\1\6\1\0\1\6\1\0"
           + "\12\6\1\113\2\6\1\0\2\6\1\0\1\6\7\0"
           + "\1\114\6\0\1\115\5\0\1\114\22\0\1\114\7\0"
           + "\1\116\6\0\1\117\5\0\1\116\22\0\1\116\7\0"
           + "\1\114\5\0\1\120\1\114\5\0\1\114\22\0\1\114"
           + "\15\0\1\120\41\0\1\116\5\0\1\121\1\116\5\0"
           + "\1\116\22\0\1\116\15\0\1\121\32\0";

   private static int[] zzUnpackTrans() {
      int[] result = new int[2320];
      int offset = 0;
      offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
      return result;
   }

   private static int zzUnpackTrans(String packed, int offset, int[] result) {
      int i = 0;       /* index in packed string  */
      int j = offset;  /* index in unpacked array */
      int l = packed.length();
      while (i < l) {
         int count = packed.charAt(i++);
         int value = packed.charAt(i++);
         value--;
         do {
            result[j++] = value;
         } while (--count > 0);
      }
      return j;
   }
   /* error codes */
   private static final int ZZ_UNKNOWN_ERROR = 0;
   private static final int ZZ_NO_MATCH = 1;
   private static final int ZZ_PUSHBACK_2BIG = 2;

   /* error messages for the codes above */
   private static final String ZZ_ERROR_MSG[] = {
      "Unkown internal scanner error",
      "Error: could not match input",
      "Error: pushback value was too large"
   };
   /**
    * ZZ_ATTRIBUTE[aState] contains the attributes of state
    * <code>aState</code>
    */
   private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();
   private static final String ZZ_ATTRIBUTE_PACKED_0 =
           "\3\0\1\11\6\1\1\11\1\1\1\11\1\1\1\11"
           + "\7\1\1\11\1\0\1\11\1\1\1\11\2\1\10\11"
           + "\1\0\1\1\1\0\1\1\1\0\1\1\1\11\1\0"
           + "\1\1\1\0\1\1\1\0\1\1\1\11\15\1\1\0"
           + "\2\1\2\0\2\1\1\11\1\1\6\0\2\11";

   private static int[] zzUnpackAttribute() {
      int[] result = new int[81];
      int offset = 0;
      offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
      return result;
   }

   private static int zzUnpackAttribute(String packed, int offset, int[] result) {
      int i = 0;       /* index in packed string  */
      int j = offset;  /* index in unpacked array */
      int l = packed.length();
      while (i < l) {
         int count = packed.charAt(i++);
         int value = packed.charAt(i++);
         do {
            result[j++] = value;
         } while (--count > 0);
      }
      return j;
   }
   /**
    * the input device
    */
   private java.io.Reader zzReader;
   /**
    * the current state of the DFA
    */
   private int zzState;
   /**
    * the current lexical state
    */
   private int zzLexicalState = YYINITIAL;
   /**
    * this buffer contains the current text to be matched and is the source of
    * the yytext() string
    */
   private char zzBuffer[] = new char[ZZ_BUFFERSIZE];
   /**
    * the textposition at the last accepting state
    */
   private int zzMarkedPos;
   /**
    * the current text position in the buffer
    */
   private int zzCurrentPos;
   /**
    * startRead marks the beginning of the yytext() string in the buffer
    */
   private int zzStartRead;
   /**
    * endRead marks the last character in the buffer, that has been read from
    * input
    */
   private int zzEndRead;
   /**
    * number of newlines encountered up to the start of the matched text
    */
   private int yyline;
   /**
    * the number of characters up to the start of the matched text
    */
   private int yychar;
   /**
    * the number of characters from the last newline up to the start of the
    * matched text
    */
   private int yycolumn;
   /**
    * zzAtBOL == true <=> the scanner is currently at the beginning of a line
    */
   private boolean zzAtBOL = true;
   /**
    * zzAtEOF == true <=> the scanner is at the EOF
    */
   private boolean zzAtEOF;
   /**
    * denotes if the user-EOF-code has already been executed
    */
   private boolean zzEOFDone;

   /* user code: */
   StringBuffer string = new StringBuffer();
   boolean isMultiname = false;
   long multinameId = 0;

   /**
    * Create an empty lexer, yyrset will be called later to reset and assign the
    * reader
    */
   public Flasm3Lexer() {
   }

   public int yychar() {
      return yychar;
   }

   public int yyline() {
      return yyline + 1;
   }

   /**
    * Creates a new scanner There is also a java.io.InputStream version of this
    * constructor.
    *
    * @param in the java.io.Reader to read input from.
    */
   public Flasm3Lexer(java.io.Reader in) {
      this.zzReader = in;
   }

   /**
    * Creates a new scanner. There is also java.io.Reader version of this
    * constructor.
    *
    * @param in the java.io.Inputstream to read input from.
    */
   public Flasm3Lexer(java.io.InputStream in) {
      this(new java.io.InputStreamReader(in));
   }

   /**
    * Unpacks the compressed character translation table.
    *
    * @param packed the packed character translation table
    * @return the unpacked character translation table
    */
   private static char[] zzUnpackCMap(String packed) {
      char[] map = new char[0x10000];
      int i = 0;  /* index in packed string  */
      int j = 0;  /* index in unpacked array */
      while (i < 1738) {
         int count = packed.charAt(i++);
         char value = packed.charAt(i++);
         do {
            map[j++] = value;
         } while (--count > 0);
      }
      return map;
   }

   /**
    * Refills the input buffer.
    *
    * @return      <code>false</code>, iff there was new input.
    *
    * @exception java.io.IOException if any I/O-Error occurs
    */
   private boolean zzRefill() throws java.io.IOException {

      /* first: make room (if you can) */
      if (zzStartRead > 0) {
         System.arraycopy(zzBuffer, zzStartRead,
                 zzBuffer, 0,
                 zzEndRead - zzStartRead);

         /* translate stored positions */
         zzEndRead -= zzStartRead;
         zzCurrentPos -= zzStartRead;
         zzMarkedPos -= zzStartRead;
         zzStartRead = 0;
      }

      /* is the buffer big enough? */
      if (zzCurrentPos >= zzBuffer.length) {
         /* if not: blow it up */
         char newBuffer[] = new char[zzCurrentPos * 2];
         System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
         zzBuffer = newBuffer;
      }

      /* finally: fill the buffer with new input */
      int numRead = zzReader.read(zzBuffer, zzEndRead,
              zzBuffer.length - zzEndRead);

      if (numRead > 0) {
         zzEndRead += numRead;
         return false;
      }
      // unlikely but not impossible: read 0 characters, but not at end of stream    
      if (numRead == 0) {
         int c = zzReader.read();
         if (c == -1) {
            return true;
         } else {
            zzBuffer[zzEndRead++] = (char) c;
            return false;
         }
      }

      // numRead < 0
      return true;
   }

   /**
    * Closes the input stream.
    */
   public final void yyclose() throws java.io.IOException {
      zzAtEOF = true;            /* indicate end of file */
      zzEndRead = zzStartRead;  /* invalidate buffer    */

      if (zzReader != null) {
         zzReader.close();
      }
   }

   /**
    * Resets the scanner to read from a new input stream. Does not close the old
    * reader.
    *
    * All internal variables are reset, the old input stream <b>cannot</b> be
    * reused (internal buffer is discarded and lost). Lexical state is set to
    * <tt>ZZ_INITIAL</tt>.
    *
    * @param reader the new input stream
    */
   public final void yyreset(java.io.Reader reader) {
      zzReader = reader;
      zzAtBOL = true;
      zzAtEOF = false;
      zzEOFDone = false;
      zzEndRead = zzStartRead = 0;
      zzCurrentPos = zzMarkedPos = 0;
      yyline = yychar = yycolumn = 0;
      zzLexicalState = YYINITIAL;
   }

   /**
    * Returns the current lexical state.
    */
   public final int yystate() {
      return zzLexicalState;
   }

   /**
    * Enters a new lexical state
    *
    * @param newState the new lexical state
    */
   public final void yybegin(int newState) {
      zzLexicalState = newState;
   }

   /**
    * Returns the text matched by the current regular expression.
    */
   public final String yytext() {
      return new String(zzBuffer, zzStartRead, zzMarkedPos - zzStartRead);
   }

   /**
    * Returns the character at position <tt>pos</tt> from the matched text.
    *
    * It is equivalent to yytext().charAt(pos), but faster
    *
    * @param pos the position of the character to fetch. A value from 0 to
    * yylength()-1.
    *
    * @return the character at position pos
    */
   public final char yycharat(int pos) {
      return zzBuffer[zzStartRead + pos];
   }

   /**
    * Returns the length of the matched text region.
    */
   public final int yylength() {
      return zzMarkedPos - zzStartRead;
   }

   /**
    * Reports an error that occured while scanning.
    *
    * In a wellformed scanner (no or only correct usage of yypushback(int) and a
    * match-all fallback rule) this method will only be called with things that
    * "Can't Possibly Happen". If this method is called, something is seriously
    * wrong (e.g. a JFlex bug producing a faulty scanner etc.).
    *
    * Usual syntax/scanner level error handling should be done in error fallback
    * rules.
    *
    * @param errorCode the code of the errormessage to display
    */
   private void zzScanError(int errorCode) {
      String message;
      try {
         message = ZZ_ERROR_MSG[errorCode];
      } catch (ArrayIndexOutOfBoundsException e) {
         message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
      }

      throw new Error(message);
   }

   /**
    * Pushes the specified amount of characters back into the input stream.
    *
    * They will be read again by then next call of the scanning method
    *
    * @param number the number of characters to be read again. This number must
    * not be greater than yylength()!
    */
   public void yypushback(int number) {
      if (number > yylength()) {
         zzScanError(ZZ_PUSHBACK_2BIG);
      }

      zzMarkedPos -= number;
   }

   /**
    * Resumes scanning until the next regular expression is matched, the end of
    * input is encountered or an I/O-Error occurs.
    *
    * @return the next token
    * @exception java.io.IOException if any I/O-Error occurs
    */
   public ParsedSymbol yylex() throws java.io.IOException, ParseException {
      int zzInput;
      int zzAction;

      // cached fields:
      int zzCurrentPosL;
      int zzMarkedPosL;
      int zzEndReadL = zzEndRead;
      char[] zzBufferL = zzBuffer;
      char[] zzCMapL = ZZ_CMAP;

      int[] zzTransL = ZZ_TRANS;
      int[] zzRowMapL = ZZ_ROWMAP;
      int[] zzAttrL = ZZ_ATTRIBUTE;

      while (true) {
         zzMarkedPosL = zzMarkedPos;

         yychar += zzMarkedPosL - zzStartRead;

         boolean zzR = false;
         for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                 zzCurrentPosL++) {
            switch (zzBufferL[zzCurrentPosL]) {
               case '\u000B':
               case '\u000C':
               case '\u0085':
               case '\u2028':
               case '\u2029':
                  yyline++;
                  yycolumn = 0;
                  zzR = false;
                  break;
               case '\r':
                  yyline++;
                  yycolumn = 0;
                  zzR = true;
                  break;
               case '\n':
                  if (zzR) {
                     zzR = false;
                  } else {
                     yyline++;
                     yycolumn = 0;
                  }
                  break;
               default:
                  zzR = false;
                  yycolumn++;
            }
         }

         if (zzR) {
            // peek one character ahead if it is \n (if we have counted one line too much)
            boolean zzPeek;
            if (zzMarkedPosL < zzEndReadL) {
               zzPeek = zzBufferL[zzMarkedPosL] == '\n';
            } else if (zzAtEOF) {
               zzPeek = false;
            } else {
               boolean eof = zzRefill();
               zzEndReadL = zzEndRead;
               zzMarkedPosL = zzMarkedPos;
               zzBufferL = zzBuffer;
               if (eof) {
                  zzPeek = false;
               } else {
                  zzPeek = zzBufferL[zzMarkedPosL] == '\n';
               }
            }
            if (zzPeek) {
               yyline--;
            }
         }
         zzAction = -1;

         zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

         zzState = ZZ_LEXSTATE[zzLexicalState];


         zzForAction:
         {
            while (true) {

               if (zzCurrentPosL < zzEndReadL) {
                  zzInput = zzBufferL[zzCurrentPosL++];
               } else if (zzAtEOF) {
                  zzInput = YYEOF;
                  break zzForAction;
               } else {
                  // store back cached positions
                  zzCurrentPos = zzCurrentPosL;
                  zzMarkedPos = zzMarkedPosL;
                  boolean eof = zzRefill();
                  // get translated positions and possibly new buffer
                  zzCurrentPosL = zzCurrentPos;
                  zzMarkedPosL = zzMarkedPos;
                  zzBufferL = zzBuffer;
                  zzEndReadL = zzEndRead;
                  if (eof) {
                     zzInput = YYEOF;
                     break zzForAction;
                  } else {
                     zzInput = zzBufferL[zzCurrentPosL++];
                  }
               }
               int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput]];
               if (zzNext == -1) {
                  break zzForAction;
               }
               zzState = zzNext;

               int zzAttributes = zzAttrL[zzState];
               if ((zzAttributes & 1) == 1) {
                  zzAction = zzState;
                  zzMarkedPosL = zzCurrentPosL;
                  if ((zzAttributes & 8) == 8) {
                     break zzForAction;
                  }
               }

            }
         }

         // store back cached position
         zzMarkedPos = zzMarkedPosL;

         switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
            case 8: {
               return new ParsedSymbol(ParsedSymbol.TYPE_IDENTIFIER, yytext());
            }
            case 27:
               break;
            case 21: {
               string.append('\'');
            }
            case 28:
               break;
            case 9: {
               return new ParsedSymbol(ParsedSymbol.TYPE_INTEGER, new Long(Long.parseLong((yytext()))));
            }
            case 29:
               break;
            case 26: {
               String s = yytext();
               return new ParsedSymbol(ParsedSymbol.TYPE_EXCEPTION_TARGET, Integer.parseInt(s.substring(16, s.length() - 1)));
            }
            case 30:
               break;
            case 3: {
               string.append(yytext());
            }
            case 31:
               break;
            case 13: {
               char val = (char) Integer.parseInt(yytext().substring(1), 8);
               string.append(val);
            }
            case 32:
               break;
            case 25: {
               String s = yytext();
               return new ParsedSymbol(ParsedSymbol.TYPE_EXCEPTION_START, Integer.parseInt(s.substring(15, s.length() - 1)));
            }
            case 33:
               break;
            case 5: {
               yybegin(PARAMETERS);
               // length also includes the trailing quote
               if (isMultiname) {
                  return new ParsedSymbol(ParsedSymbol.TYPE_MULTINAME, new Long(multinameId));
               } else {
                  return new ParsedSymbol(ParsedSymbol.TYPE_STRING, string.toString());
               }
            }
            case 34:
               break;
            case 6: {
               yybegin(YYINITIAL);
            }
            case 35:
               break;
            case 2: {
               yybegin(PARAMETERS);
               return new ParsedSymbol(ParsedSymbol.TYPE_INSTRUCTION_NAME, yytext());
            }
            case 36:
               break;
            case 17: {
               string.append('\r');
            }
            case 37:
               break;
            case 24: {
               String s = yytext();
               return new ParsedSymbol(ParsedSymbol.TYPE_EXCEPTION_END, Integer.parseInt(s.substring(13, s.length() - 1)));
            }
            case 38:
               break;
            case 7: {
               return new ParsedSymbol(ParsedSymbol.TYPE_COMMENT, yytext().substring(1));
            }
            case 39:
               break;
            case 19: {
               string.append('\b');
            }
            case 40:
               break;
            case 11: {
               String s = yytext();
               return new ParsedSymbol(ParsedSymbol.TYPE_LABEL, s.substring(0, s.length() - 1));
            }
            case 41:
               break;
            case 4: {
               throw new ParseException("Unterminated string at end of line", yyline + 1);
            }
            case 42:
               break;
            case 10: {
               isMultiname = false;
               yybegin(STRING);
               string.setLength(0);
            }
            case 43:
               break;
            case 15: {
               string.append('\t');
            }
            case 44:
               break;
            case 22: {
               return new ParsedSymbol(ParsedSymbol.TYPE_FLOAT, new Double(Double.parseDouble((yytext()))));
            }
            case 45:
               break;
            case 14: {
               string.append('\\');
            }
            case 46:
               break;
            case 12: {
               throw new ParseException("Illegal escape sequence \"" + yytext() + "\"", yyline + 1);
            }
            case 47:
               break;
            case 23: {
               isMultiname = true;
               String s = yytext();
               multinameId = Long.parseLong(s.substring(2, s.length() - 2));
               yybegin(STRING);
               string.setLength(0);
            }
            case 48:
               break;
            case 16: {
               string.append('\n');
            }
            case 49:
               break;
            case 20: {
               string.append('\f');
            }
            case 50:
               break;
            case 18: {
               string.append('\"');
            }
            case 51:
               break;
            case 1: {
            }
            case 52:
               break;
            default:
               if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
                  zzAtEOF = true;
                  {
                     return new ParsedSymbol(ParsedSymbol.TYPE_EOF);
                  }
               } else {
                  zzScanError(ZZ_NO_MATCH);
               }
         }
      }
   }
}