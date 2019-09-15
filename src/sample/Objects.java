package sample;

import java.io.File;

public class Objects {
	public static final String realPath(String path) {
		String base = System.getProperty("user.dir");
		path = path.replaceAll("\\\\", "/");
		if (File.separatorChar == '\\') {
			path = path.replaceAll("/", "\\\\");
		}
		return new File(base, path).getAbsolutePath();
	}

	public static final String join(String... strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		for (String str : strs) {
			s.append(" ").append(str);
		}
		return s.substring(1);
	}

	public static final String elevate(String script) {
		String cmd = realPath("sample/program/nircmd.exe");
		return join(cmd, "elevate", realPath(script));
	}
}
