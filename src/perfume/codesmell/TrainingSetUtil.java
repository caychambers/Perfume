package perfume.codesmell;

import java.util.ArrayList;

import perfume.util.FileUtil;

public class TrainingSetUtil {
	
	public void makeTrainningSet(String dirName, AbstractCodeSmell codeSmell) {
		ArrayList<String> projectNameList = FileUtil.getAllProjectName(dirName);
		for (String projectName: projectNameList) {
			codeSmell.makeTrainingSet(dirName, projectName);
		}
	}
}
