package assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;


public class DivideAndConquer {
	
	public static void filesort(String inputFile, String outputFile, int maxLineCount) {
		ArrayList<String> lines = new ArrayList<>();
		Path path = FileSystems.getDefault().getPath("../../", inputFile);
		Charset charset = Charset.forName("UTF-8");
		try (BufferedReader in = Files.newBufferedReader(path, charset)){
			String line;
			while((line = in.readLine()) != null){
				lines.add(line);
			}
			in.close();
		} catch (IOException e) {
			
		}
		mergesort(lines);
		Path out = FileSystems.getDefault().getPath("../../", outputFile);
		try (BufferedWriter write = Files.newBufferedWriter(out, charset)){
			while (!lines.isEmpty()){
				write.write(lines.get(0));
				lines.remove(0);
			}
			write.close();
		} catch (IOException e) {
			
		}
	}
	
	public static <X extends Comparable<X>> void mergesort(ArrayList<X> list) {
		ArrayList<X> helpList = mergesortHelp(list);
		list.clear();
		for (int i = 0; i < helpList.size(); i++){
			list.add(helpList.get(i));
		}
	}
	
	public static <X extends Comparable<X>> ArrayList<X> mergesortHelp(ArrayList<X> list){
		if (list.size() <= 1){
			return list;
		}
		ArrayList<X> leftList = new ArrayList<X>();
		ArrayList<X> rightList = new ArrayList<X>();
		for (int i = 0; i < list.size(); i++){
			if (i < list.size()/2){
				leftList.add(list.get(i));
			} else {
				rightList.add(list.get(i));
			}
		}
		leftList = mergesortHelp(leftList);
		rightList = mergesortHelp(rightList);
		return merge(leftList, rightList);
	}
	
	public static <X extends Comparable<X>> ArrayList<X> merge(ArrayList<X> leftList, ArrayList<X> rightList){
		ArrayList<X> result = new ArrayList<X>();
		while (!leftList.isEmpty() && !rightList.isEmpty()){
			if (leftList.get(0).compareTo(rightList.get(0)) <= 0){
				result.add(leftList.get(0));
				leftList.remove(0);
			}
			else if (leftList.get(0).compareTo(rightList.get(0)) > 0){
				result.add(rightList.get(0));
				rightList.remove(0);
			}
		}
		while (!leftList.isEmpty()){
			result.add(leftList.get(0));
			leftList.remove(0);
		}
		while (!rightList.isEmpty()){
			result.add(rightList.get(0));
			rightList.remove(0);
		}
		
		return result;
	}
}
