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
package com.jpexs.decompiler.flash.tags.base;

import com.jpexs.decompiler.flash.SWF;
import com.jpexs.decompiler.flash.tags.ExportAssetsTag;
import com.jpexs.decompiler.flash.tags.Tag;
import com.jpexs.decompiler.flash.types.annotations.Internal;
import com.jpexs.helpers.ByteArrayRange;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JPEXS
 */
public abstract class CharacterIdTag extends Tag {

    public CharacterIdTag(SWF swf, int id, String name, ByteArrayRange data) {
        super(swf, id, name, data);
    }

    public abstract int getCharacterId();
    /**
     * List of ExportAssetsTag used for converting to String
     */
    @Internal
    public List<ExportAssetsTag> exportAssetsTags = new ArrayList<>();
    protected String exportName;

    public void setExportName(String exportName) {
        this.exportName = exportName;
    }

    @Override
    public String getName() {
        String nameAppend = "";
        if (exportName != null) {
            nameAppend = ": " + exportName;
        }
        if (getCharacterId() != -1) {
            return super.getName() + " (" + getCharacterId() + nameAppend + ")";
        }
        if (!nameAppend.isEmpty()) {
            return super.getName() + " (" + nameAppend + ")";
        }
        return super.getName();
    }

    @Override
    public String getExportFileName() {
        return super.getName() + "_" + getCharacterId() + (((exportName != null) && (!exportName.isEmpty())) ? "_" + exportName : "");
    }

    public String getCharacterExportFileName() {
        return getCharacterId() + (((exportName != null) && (!exportName.isEmpty())) ? "_" + exportName : "");
    }

    public String getExportName() {
        return exportName;
    }
}
