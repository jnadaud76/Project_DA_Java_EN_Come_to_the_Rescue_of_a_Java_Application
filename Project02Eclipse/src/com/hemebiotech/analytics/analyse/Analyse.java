package com.hemebiotech.analytics.analyse;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.count.ISymptomCounter;
import com.hemebiotech.analytics.read.ISymptomReader;
import com.hemebiotech.analytics.write.ISymptomWriter;

/**
 * Manage the process of reading, counting and writing data.
 * 
 * @author Johan Nadaud
 *
 */
public class Analyse {
	/**
	 * an object which implement the ISymptomReader interface
	 */
	private ISymptomReader reader;
	/**
	 * an object which implement the ISymptomCounter interface
	 */
	private ISymptomCounter counter;
	/**
	 * an object which implement the ISymptomWriter interface
	 */
	private ISymptomWriter writer;

	/**
	 * Analyse constructor.
	 * 
	 * @param readerFromMain  an object which implement the ISymptomReader interface
	 * @param counterFromMain an object which implement the ISymptomCounter
	 *                        interface
	 * @param writerFromMain  an object which implement the ISymptomWriter interface
	 * 
	 * @see ISymptomReader
	 * @see ISymptomCounter
	 * @see ISymptomWriter
	 */
	public Analyse(ISymptomReader readerFromMain, ISymptomCounter counterFromMain, ISymptomWriter writerFromMain) {
		this.reader = readerFromMain;
		this.counter = counterFromMain;
		this.writer = writerFromMain;
	}

	/**
	 * Return a list of Symptoms
	 * 
	 * @return a raw listing of all Symptoms obtained from a file, duplicates are
	 *         possible/probable
	 */
	public List<String> getSymptoms() {
		return this.reader.getSymptoms();
	}

	/**
	 * Count and ordered the list of Symptoms
	 * 
	 * @param listNotCounted a raw listing of all Symptoms obtained from a file,
	 *                       duplicates are possible/probable
	 * @return a map of all Symptoms obtained from a List with no duplication
	 *         classify by alphabetical order. Each symptom will be associated with
	 *         a counter indicating the number of times it appears in the map.
	 */
	public Map<String, Integer> countSymptoms(List<String> listNotCounted) {
		return this.counter.countSymptoms(listNotCounted);
	}

	/**
	 * Write the ordered list of Symptoms
	 * 
	 * @param mapCountedAndSorted a map of all Symptoms obtained from a List with no
	 *                            duplication classify by alphabetical order. Each
	 *                            symptom will be associated with a counter
	 *                            indicating the number of times it appears in the
	 *                            map.
	 *
	 */
	public void writeSymptoms(Map<String, Integer> mapCountedAndSorted) {
		this.writer.writeSymptoms(mapCountedAndSorted);
	}

}
