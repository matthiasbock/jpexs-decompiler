package com.jpexs.browsers.cache.chrome;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JPEXS
 */
public class Index {

    IndexHeader header;
    CacheAddr table[];
    public static final int kIndexTablesize = 0x10000;
    public File rootDir;
    private Map<Integer, RandomAccessFile> dataFiles;
    private File externalFilesDir;

    public void free() {
        for (RandomAccessFile r : dataFiles.values()) {
            try {
                r.close();
            } catch (IOException ex) {
            }
        }
    }

    public List<EntryStore> getEntries() throws IOException {
        List<EntryStore> ret = new ArrayList<>();
        for (CacheAddr ca : table) {
            InputStream is = ca.getInputStream();
            if (is != null) {
                EntryStore es = new EntryStore(is, rootDir, dataFiles, externalFilesDir);
                ret.add(es);
            }
        }
        return ret;
    }

    public Index(File file, File externalFilesDir) throws IOException {
        dataFiles = new HashMap<>();
        this.externalFilesDir = externalFilesDir;
        try (FileInputStream is = new FileInputStream(file)) {
            rootDir = file.getParentFile();
            header = new IndexHeader(is, rootDir, dataFiles, externalFilesDir);
            int tsize = kIndexTablesize;
            if (header.table_len > 0) {
                tsize = header.table_len;
            }
            table = new CacheAddr[tsize];
            for (int i = 0; i < tsize; i++) {
                table[i] = new CacheAddr(is, rootDir, dataFiles, externalFilesDir);
            }
        }
    }
}