/*
 * Copyright (C) 2014 JPEXS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jpexs.decompiler.flash.treeitems;

import com.jpexs.decompiler.flash.AppStrings;
import com.jpexs.decompiler.flash.SWF;

/**
 *
 * @author JPEXS
 */
public class HeaderItem implements TreeItem {

    private SWF swf;

    public HeaderItem(SWF swf) {
        this.swf = swf;
    }
    
    
    
    @Override
    public SWF getSwf() {
        return swf;
    }

    @Override
    public String toString() {
        return AppStrings.translate("node.header");
    }
    
    
    
}
