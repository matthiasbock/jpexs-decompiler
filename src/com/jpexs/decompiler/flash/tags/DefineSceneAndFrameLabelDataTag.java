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
package com.jpexs.decompiler.flash.tags;

import com.jpexs.decompiler.flash.SWFInputStream;
import com.jpexs.decompiler.flash.SWFOutputStream;
import com.jpexs.decompiler.flash.types.BasicType;
import com.jpexs.decompiler.flash.types.annotations.SWFArray;
import com.jpexs.decompiler.flash.types.annotations.SWFType;
import com.jpexs.helpers.ByteArrayRange;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 *
 * @author JPEXS
 */
public class DefineSceneAndFrameLabelDataTag extends Tag {

    @SWFType(value = BasicType.EncodedU32)
    @SWFArray(value = "offset", countField = "sceneCount")
    public long[] sceneOffsets;
    @SWFArray(value = "name", countField = "sceneCount")
    public String[] sceneNames;

    @SWFType(value = BasicType.EncodedU32)
    @SWFArray(value = "frameNum", countField = "frameLabelCount")
    public long[] frameNums;

    @SWFArray(countField = "frameLabelCount")
    public String[] frameNames;
    public static final int ID = 86;

    /**
     * Gets data bytes
     *
     * @return Bytes of data
     */
    @Override
    public byte[] getData() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream os = baos;
        SWFOutputStream sos = new SWFOutputStream(os, getVersion());
        try {
            int sceneCount = sceneOffsets.length;
            sos.writeEncodedU32(sceneCount);
            for (int i = 0; i < sceneCount; i++) {
                sos.writeEncodedU32(sceneOffsets[i]);
                sos.writeString(sceneNames[i]);
            }
            int frameLabelCount = frameNums.length;
            sos.writeEncodedU32(frameLabelCount);
            for (int i = 0; i < frameLabelCount; i++) {
                sos.writeEncodedU32(frameNums[i]);
                sos.writeString(frameNames[i]);
            }
        } catch (IOException e) {
        }
        return baos.toByteArray();
    }

    /**
     * Constructor
     *
     * @param sis
     * @param data
     * @throws IOException
     */
    public DefineSceneAndFrameLabelDataTag(SWFInputStream sis, ByteArrayRange data) throws IOException {
        super(sis.getSwf(), ID, "DefineSceneAndFrameLabelData", data);
        int sceneCount = (int) sis.readEncodedU32("sceneCount");
        sceneOffsets = new long[sceneCount];
        sceneNames = new String[sceneCount];
        for (int i = 0; i < sceneCount; i++) {
            sceneOffsets[i] = sis.readEncodedU32("sceneOffset");
            sceneNames[i] = sis.readString("sceneName");
        }
        int frameLabelCount = (int) sis.readEncodedU32("frameLabelCount");
        frameNums = new long[frameLabelCount];
        frameNames = new String[frameLabelCount];
        for (int i = 0; i < frameLabelCount; i++) {
            frameNums[i] = sis.readEncodedU32("frameNum");
            frameNames[i] = sis.readString("frameName");
        }

    }
}
