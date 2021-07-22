package net.aydini.jawpdater.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class FileUtil {

	
	
	public static void saveFile(byte[] content , String fileName)
	{
		try {
			FileUtils.writeByteArrayToFile(new File(fileName), content);
		} catch (IOException e) {
			log.error("fail to save file {}. cause : {}",fileName,e.getMessage());
		}	
	}
	
	
	public static boolean isBinaryExist()
	{
		File file = new File("printer.jar");
		return file .exists();
	}
}
