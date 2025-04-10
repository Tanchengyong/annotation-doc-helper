package com.tancy.plug.shouce;


import com.intellij.openapi.diagnostic.Logger;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnnotationDocLoader {
    private static final Logger LOG = Logger.getInstance(AnnotationDocLoader.class);
    private static final Map<String, String> DOC_MAP = new HashMap<>();


    public static String getHtmlStr(String fileName) {
        String annoName = "@" + fileName.substring(fileName.lastIndexOf(".") + 1);
        if (DOC_MAP.containsKey(fileName)) {
            return DOC_MAP.get(fileName);
        }
        String html = AnnoConfig.NotFound;

        URL resource = AnnotationDocLoader.class.getClassLoader().getResource("AnnoHtml/" + fileName + ".html");
        if (resource != null) {
            try (InputStream inputStream = resource.openStream();
                 Scanner scc = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                StringBuilder content = new StringBuilder();
                while (scc.hasNextLine()) {
                    content.append(scc.nextLine()).append("\n");
                }
                html = content.toString();
            } catch (IOException e) {
                LOG.error("读取文件时发生错误: " + e.getMessage());
            }
        }

        String replace = html.replace("${style}", AnnoConfig.Style)
                .replace("${annoName}", annoName)
                .replace("${annoNamePackage}", fileName);
        DOC_MAP.put(fileName, replace);
        return replace;
    }
 }
