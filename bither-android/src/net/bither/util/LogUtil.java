/* * Copyright 2014 http://Bither.net * * Licensed under the Apache License, Version 2.0 (the "License"); * you may not use this file except in compliance with the License. * You may obtain a copy of the License at * *    http://www.apache.org/licenses/LICENSE-2.0 * * Unless required by applicable law or agreed to in writing, software * distributed under the License is distributed on an "AS IS" BASIS, * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. * See the License for the specific language governing permissions and * limitations under the License. */package net.bither.util;import java.io.File;import java.io.FileOutputStream;import net.bither.BitherSetting;import android.util.Log;public class LogUtil {	public static void i(String tag, String content) {		if (BitherSetting.LOG_DEBUG) {			Log.i(tag, content);		}	}	public static void d(String tag, String content) {		if (BitherSetting.LOG_DEBUG) {			Log.d(tag, content);		}	}	public static void w(String tag, String content) {		if (BitherSetting.LOG_DEBUG) {			Log.w(tag, content);		}	}	public static void e(String tag, String content) {		if (BitherSetting.LOG_DEBUG) {			Log.e(tag, content);		}	}	public static void recordLog(File savePath, String saveFileName,			String data, boolean saveType) {		FileOutputStream fos = null;		try {			if (!savePath.exists())				savePath.mkdirs();			File saveFile = new File(savePath, saveFileName);			if (!saveType && saveFile.exists()) {				saveFile.delete();				saveFile.createNewFile();				fos = new FileOutputStream(saveFile, saveType);			} else if (saveType && saveFile.exists()) {				fos = new FileOutputStream(saveFile, saveType);			} else if (saveType && !saveFile.exists()) {				saveFile.createNewFile();				fos = new FileOutputStream(saveFile, saveType);			} else {				fos = new FileOutputStream(saveFile, saveType);			}			fos.write(data.getBytes());			fos.close();		} catch (Exception e) {			e.printStackTrace();		} finally {		}	}}