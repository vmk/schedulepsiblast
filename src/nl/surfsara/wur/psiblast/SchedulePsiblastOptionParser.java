package nl.surfsara.wur.psiblast;

import java.io.File;
import java.util.ArrayList;

import joptsimple.OptionParser;
import joptsimple.OptionSpec;

public class SchedulePsiblastOptionParser extends OptionParser {
	public OptionSpec<String> projectId;
	public OptionSpec<File> sampleFile;
	@SuppressWarnings("rawtypes")
	public OptionSpec help;
	@SuppressWarnings("rawtypes")
	public OptionSpec retract;
	@SuppressWarnings("rawtypes")
	public OptionSpec report;
	@SuppressWarnings("rawtypes")
	public OptionSpec get;
	
	public SchedulePsiblastOptionParser() {
		super();

		// Option declaration
		ArrayList<String> projectIdOption = new ArrayList<String>();
		projectIdOption.add("id");
		projectIdOption.add("projectid");
		
		
		ArrayList<String> sampleFileOption = new ArrayList<String>();
		sampleFileOption.add("s");
		sampleFileOption.add("f");
		sampleFileOption.add("fasta");
		
		ArrayList<String> helpCommand = new ArrayList<String>();
		helpCommand.add("h");
		helpCommand.add("?");
		helpCommand.add("help");
		
		ArrayList<String> retractOption = new ArrayList<String>();
		retractOption.add("retract");
		retractOption.add("delete");
		
		ArrayList<String> reportOption = new ArrayList<String>();
		reportOption.add("report");
		reportOption.add("progress");
		
		ArrayList<String> getOption = new ArrayList<String>();
		getOption.add("retrieve");
		getOption.add("get");
		
		// accept rules:
		projectId = acceptsAll(projectIdOption, "Required. The project name. Used as id to store job information and output files.").withRequiredArg().ofType(String.class).describedAs("string");
		sampleFile = acceptsAll(sampleFileOption, "Required. The .fasta file with the protein(s).").withRequiredArg().ofType(File.class).describedAs("file");
		retract = acceptsAll(retractOption, "Optional. Retracts or deletes all jobs matching the project name.");
		report = acceptsAll(reportOption, "Optional. Displays a report on job progress. Requires a project name.");
		get = acceptsAll(getOption, "Optional. Gets all the curent output files to the current directory. Requires a project name.");
		help = acceptsAll(helpCommand, "Prints usage information.");
	}



}
