package com.tancy.plug.shouce;

public class AnnoConfig {

    public static final String Style = "<head>\n" +
            "<style type=\"text/css\">\n" +
            "                      body {\n" +
            "                          font-family: Arial, sans-serif;\n" +
            "                          margin: 20px;\n" +
            "                          background-color: #232944;\n" +
            "                          color: #2d3748;\n" +
            "                      }\n" +
            "\n" +
            "h1 {\n" +
            "    color: #9790f8;\n" +
            "    border-bottom: 3px solid #cbd5e0;\n" +
            "    padding-bottom: 10px;\n" +
            "    font-size: 24px;\n" +
            "}\n" +
            "\n" +
            ".section {\n" +
            "    background: #20273e;\n" +
            "    border: 1px solid #7d71ee;\n" +
            "    border-radius: 6px;\n" +
            "    padding: 15px;\n" +
            "    color: white;\n" +
            "    margin: 15px 0;\n" +
            "}\n" +
            "\n" +
            "h2 {\n" +
            "    color: #9790f8;\n" +
            "    font-size: 18px;\n" +
            "    margin: 10px 0;\n" +
            "}\n" +
            "\n" +
            "code {\n" +
            "    font-family: 'Courier New', monospace;\n" +
            "    background-color: #1f263c;\n" +
            "    padding: 2px 5px;\n" +
            "    color: #b88f2e;\n" +
            "    border-radius: 3px;\n" +
            "    border: 1px solid #bee3f8;\n" +
            "}\n" +
            "\n" +
            "pre {\n" +
            "    background: #1f263c;\n" +
            "    padding: 12px;\n" +
            "    color: #e8e9ed;\n" +
            "    border-left: 4px solid #4299e1;\n" +
            "    overflow-x: auto;\n" +
            "    margin: 10px 0;\n" +
            "}\n" +
            "\n" +
            "table {\n" +
            "    width: 100%;\n" +
            "    border-collapse: collapse;\n" +
            "    margin: 15px 0;\n" +
            "}\n" +
            "\n" +
            "th {\n" +
            "    background-color: #232944;\n" +
            "    color: white;\n" +
            "    padding: 8px;\n" +
            "    text-align: left;\n" +
            "}\n" +
            "\n" +
            "td {\n" +
            "    border: 1px solid #cbd5e0;\n" +
            "    padding: 8px;\n" +
            "}\n" +
            "\n" +
            "ul {\n" +
            "    padding-left: 20px;\n" +
            "}\n" +
            "\n" +
            "li {\n" +
            "    margin: 5px 0;\n" +
            "}\n" +
            ".resource{\n" +
            "    color:orange;\n" +
            "    font-size: 15px;\n" +
            "    font-weight: 600;\n" +
            "}\n" +
            ".package{\n" +
            "    padding-left: 10px;\n" +
            "    color:white;\n" +
            "    font-size: 15px;\n" +
            "}\n" +
            "</style>\n" +
            "<title></title>\n" +
            "</head>";


    public static  String NotFound = "<html lang=\"\">\n" +
            "${style}\n" +
            "<body>\n" +
            "\n" +
            "<h1> ${annoName} 注解用法详解</h1>\n" +
            "<span class=\"resource\">来源：</span><span class=\"package\">${annoNamePackage}</span>\n" +
            "<div class=\"section\">\n" +
            "    <h2>&#x1F680 实在抱歉,该注解还未被收纳~</h2>\n" +
            "    <p><strong>您可以通过以下方式反馈至：tancy</strong></p>\n" +
            "    <ul>\n" +
            "        <li>邮箱：1977371754@qq.com</li>\n" +
            "        <li>github：https://github.com/Tanchengyong/annotation-doc-helper</li>\n" +
            "    </ul>\n" +
            "</div>\n" +
            "\n" +
            "</body>\n" +
            "</html>";
}
