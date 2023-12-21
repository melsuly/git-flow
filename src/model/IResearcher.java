package model;

import java.util.Comparator;

public interface IResearcher {
	void printPapers(Comparator<ResearchPaper> comparator);
	int calculateHIndex();
}
