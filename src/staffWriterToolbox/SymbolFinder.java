/*
 * @package: staffWriterToolbox
 * @file: SymbolFinder.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffWriterToolbox;

/**
 * The Class SymbolFinder.
 */
class SymbolFinder {
	/**
	 * Finds symbol for the note generated.
	 * 
	 * @param note
	 *            the note
	 * @return the char[], the symbol for the note
	 */
	public static char[] findSymbol(Note note) {
		char[] symbol = null;
		if (note.getMidiNumber() >= 39.5 & note.getMidiNumber() < 40.5) {
			symbol = getE2(note, symbol);
		} else if (note.getMidiNumber() >= 40.5 & note.getMidiNumber() < 41.5) {
			symbol = getF2(note, symbol);
		} else if (note.getMidiNumber() >= 41.5 & note.getMidiNumber() < 42.5) {
			symbol = getF2Sharp(note, symbol);
		} else if (note.getMidiNumber() >= 42.5 & note.getMidiNumber() < 43.5) {
			symbol = getG2(note, symbol);
		} else if (note.getMidiNumber() >= 43.5 & note.getMidiNumber() < 44.5) {
			symbol = getA2Flat(note, symbol);
		} else if (note.getMidiNumber() >= 44.5 & note.getMidiNumber() < 45.5) {
			symbol = getA2(note, symbol);
		} else if (note.getMidiNumber() >= 45.5 & note.getMidiNumber() < 46.5) {
			symbol = getB2Flat(note, symbol);
		} else if (note.getMidiNumber() >= 46.5 & note.getMidiNumber() < 47.5) {
			symbol = getB2(note, symbol);
		} else if (note.getMidiNumber() >= 47.5 & note.getMidiNumber() < 48.5) {
			symbol = getC2(note, symbol);
		} else if (note.getMidiNumber() >= 48.5 & note.getMidiNumber() < 49.5) {
			symbol = getC2Sharp(note, symbol);
		} else if (note.getMidiNumber() >= 49.5 & note.getMidiNumber() < 50.5) {
			symbol = getD2(note, symbol);
		} else if (note.getMidiNumber() >= 50.5 & note.getMidiNumber() < 51.5) {
			symbol = getE3Flat(note, symbol);
		} else if (note.getMidiNumber() >= 51.5 & note.getMidiNumber() < 52.5) {
			symbol = getE3(note, symbol);
		} else if (note.getMidiNumber() >= 52.5 & note.getMidiNumber() < 53.5) {
			symbol = getF3(note, symbol);
		} else if (note.getMidiNumber() >= 53.5 & note.getMidiNumber() < 54.5) {
			symbol = getF3Sharp(note, symbol);
		} else if (note.getMidiNumber() >= 54.5 & note.getMidiNumber() < 55.5) {
			symbol = getG3(note, symbol);
		} else if (note.getMidiNumber() >= 55.5 & note.getMidiNumber() < 56.5) {
			symbol = getA3Flat(note, symbol);
		} else if (note.getMidiNumber() >= 56.5 & note.getMidiNumber() < 57.5) {
			symbol = getA3(note, symbol);
		} else if (note.getMidiNumber() >= 57.5 & note.getMidiNumber() < 58.5) {
			symbol = getB3Flat(note, symbol);
		} else if (note.getMidiNumber() >= 58.5 & note.getMidiNumber() < 59.5) {
			symbol = getB3(note, symbol);
		} else if (note.getMidiNumber() >= 59.5 & note.getMidiNumber() < 60.5) {
			symbol = getC3(note, symbol);
		} else if (note.getMidiNumber() >= 60.5 & note.getMidiNumber() < 61.5) {
			symbol = getC3Sharp(note, symbol);
		} else if (note.getMidiNumber() >= 61.5 & note.getMidiNumber() < 62.5) {
			symbol = getD3(note, symbol);
		} else if (note.getMidiNumber() >= 62.5 & note.getMidiNumber() < 63.5) {
			symbol = getE4Flat(note, symbol);
		} else if (note.getMidiNumber() >= 63.5 & note.getMidiNumber() < 64.5) {
			symbol = getE4(note, symbol);
		} else if (note.getMidiNumber() >= 64.5 & note.getMidiNumber() < 65.5) {
			symbol = getF4(note, symbol);
		} else if (note.getMidiNumber() >= 65.5 & note.getMidiNumber() < 66.5) {
			symbol = getF4Sharp(note, symbol);
		} else if (note.getMidiNumber() >= 66.5 & note.getMidiNumber() < 67.5) {
			symbol = getG4(note, symbol);
		} else if (note.getMidiNumber() >= 67.5 & note.getMidiNumber() < 68.5) {
			symbol = getA4Flat(note, symbol);
		} else if (note.getMidiNumber() >= 68.5 & note.getMidiNumber() < 69.5) {
			symbol = getA4(note, symbol);
		} else if (note.getMidiNumber() >= 69.5 & note.getMidiNumber() < 70.5) {
			symbol = getB4Flat(note, symbol);
		} else if (note.getMidiNumber() >= 70.5 & note.getMidiNumber() < 71.5) {
			symbol = getB4(note, symbol);
		} else if (note.getMidiNumber() >= 71.5 & note.getMidiNumber() < 72.5) {
			symbol = getC4(note, symbol);
		} else if (note.getMidiNumber() >= 72.5 & note.getMidiNumber() < 73.5) {
			symbol = getC4Sharp(note, symbol);
		} else if (note.getMidiNumber() >= 73.5 & note.getMidiNumber() < 74.5) {
			symbol = getD4(note, symbol);
		} else if (note.getMidiNumber() >= 74.5 & note.getMidiNumber() < 75.5) {
			symbol = getE5Flat(note, symbol);
		} else if (note.getMidiNumber() >= 75.5 & note.getMidiNumber() < 76.5) {
			symbol = getE5(note, symbol);
		} else if (note.getMidiNumber() >= 76.5 & note.getMidiNumber() < 77.5) {
			symbol = getF5(note, symbol);
		} else if (note.getMidiNumber() >= 77.5 & note.getMidiNumber() < 78.5) {
			symbol = getF5Sharp(note, symbol);
		} else if (note.getMidiNumber() >= 78.5 & note.getMidiNumber() < 79.5) {
			symbol = getG5(note, symbol);
		} else if (note.getMidiNumber() >= 79.5 & note.getMidiNumber() < 80.5) {
			symbol = getA5Flat(note, symbol);
		} else if (note.getMidiNumber() >= 80.5 & note.getMidiNumber() < 81.5) {
			symbol = getA5(note, symbol);
		} else if (note.getMidiNumber() >= 81.5 & note.getMidiNumber() < 82.5) {
			symbol = getB5Flat(note, symbol);
		} else if (note.getMidiNumber() >= 82.5 & note.getMidiNumber() < 83.5) {
			symbol = getB5(note, symbol);
		} else if (note.getMidiNumber() >= 83.5 & note.getMidiNumber() < 84.5) {
			symbol = getC5(note, symbol);
		}
		return symbol;
	}

	/**
	 * Gets the e2.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the e2
	 */
	private static char[] getE2(Note note, char[] symbol) {
		note.setInLowerBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 105
					: (char) 103;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 185
					: (char) 183;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 105
					: (char) 103;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 89
					: (char) 87;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 121
					: (char) 119;
		}
		return symbol;
	}

	/**
	 * Gets the f2.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the f2
	 */
	private static char[] getF2(Note note, char[] symbol) {
		note.setInLowerBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 106
					: (char) 104;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 186
					: (char) 184;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 106
					: (char) 104;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 90
					: (char) 88;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 122
					: (char) 120;
		}
		return symbol;
	}

	/**
	 * Gets the f2 sharp.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the f2 sharp
	 */
	private static char[] getF2Sharp(Note note, char[] symbol) {
		note.setInLowerBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 218
					: (char) 216;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 106
					: (char) 104;
			symbol[2] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 186
					: (char) 184;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 218
					: (char) 216;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 106
					: (char) 104;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 218
					: (char) 216;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 90
					: (char) 88;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 218
					: (char) 216;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 122
					: (char) 120;
		}
		return symbol;
	}

	/**
	 * Gets the g2.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the g2
	 */
	private static char[] getG2(Note note, char[] symbol) {
		note.setInLowerBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 107
					: (char) 105;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 187
					: (char) 185;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 107
					: (char) 105;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 91
					: (char) 89;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 123
					: (char) 121;
		}
		return symbol;
	}

	/**
	 * Gets the a2 flat.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the a2 flat
	 */
	private static char[] getA2Flat(Note note, char[] symbol) {
		note.setInLowerBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 236
					: (char) 234;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 108
					: (char) 106;
			symbol[2] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 188
					: (char) 186;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 236
					: (char) 234;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 108
					: (char) 106;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 236
					: (char) 234;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 92
					: (char) 90;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 236
					: (char) 234;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 124
					: (char) 122;
		}
		return symbol;
	}

	/**
	 * Gets the a2.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the a2
	 */
	private static char[] getA2(Note note, char[] symbol) {
		note.setInLowerBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 108
					: (char) 106;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 188
					: (char) 186;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 108
					: (char) 106;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 92
					: (char) 90;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 124
					: (char) 122;
		}
		return symbol;
	}

	/**
	 * Gets the b2 flat.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the b2 flat
	 */
	private static char[] getB2Flat(Note note, char[] symbol) {
		note.setInLowerBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 237
					: (char) 235;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 109
					: (char) 107;
			symbol[2] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 189
					: (char) 187;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 237
					: (char) 235;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 109
					: (char) 107;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 237
					: (char) 235;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 93
					: (char) 91;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 237
					: (char) 235;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 125
					: (char) 123;
		}
		return symbol;
	}

	/**
	 * Gets the b2.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the b2
	 */
	private static char[] getB2(Note note, char[] symbol) {
		note.setInLowerBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 109
					: (char) 107;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 189
					: (char) 187;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 109
					: (char) 107;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 93
					: (char) 91;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 125
					: (char) 123;
		}
		return symbol;
	}

	/**
	 * Gets the c2.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the c2
	 */
	private static char[] getC2(Note note, char[] symbol) {
		note.setInLowerBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 110
					: (char) 108;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 190
					: (char) 188;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 110
					: (char) 108;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 94
					: (char) 92;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 126
					: (char) 124;
		}
		return symbol;
	}

	/**
	 * Gets the c2 sharp.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the c2 sharp
	 */
	private static char[] getC2Sharp(Note note, char[] symbol) {
		note.setInLowerBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 222
					: (char) 220;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 110
					: (char) 108;
			symbol[2] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 190
					: (char) 188;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 222
					: (char) 220;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 110
					: (char) 108;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 222
					: (char) 220;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 94
					: (char) 92;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 222
					: (char) 220;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 126
					: (char) 124;
		}
		return symbol;
	}

	/**
	 * Gets the d2.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the d2
	 */
	private static char[] getD2(Note note, char[] symbol) {
		if ((StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff)) {
			note.setInMiddleBar(true);
		} else {
			note.setInLowerBar(true);
		}
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 99
					: (char) 109;
			symbol[1] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 179
					: (char) 189;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 99
					: (char) 109;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 83
					: (char) 93;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) ? (char) 115
					: (char) 125;
		}
		return symbol;
	}

	/**
	 * Gets the e3 flat.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the e3 flat
	 */
	private static char[] getE3Flat(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (char) 228;
			symbol[1] = (char) 100;
			symbol[2] = (char) 180;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 228;
			symbol[1] = (char) 100;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (char) 228;
			symbol[1] = (char) 84;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (char) 228;
			symbol[1] = (char) 116;
		}
		return symbol;
	}

	/**
	 * Gets the e3.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the e3
	 */
	private static char[] getE3(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 100;
			symbol[1] = (char) 180;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 100;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 84;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 116;
		}
		return symbol;
	}

	/**
	 * Gets the f3.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the f3
	 */
	private static char[] getF3(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 101;
			symbol[1] = (char) 181;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 101;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 85;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 117;
		}
		return symbol;
	}

	/**
	 * Gets the f3 sharp.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the f3 sharp
	 */
	private static char[] getF3Sharp(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (char) 213;
			symbol[1] = (char) 101;
			symbol[2] = (char) 181;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 213;
			symbol[1] = (char) 101;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (char) 213;
			symbol[1] = (char) 85;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (char) 213;
			symbol[1] = (char) 117;
		}
		return symbol;
	}

	/**
	 * Gets the g3.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the g3
	 */
	private static char[] getG3(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 102;
			symbol[1] = (char) 182;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 102;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 86;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 118;
		}
		return symbol;
	}

	/**
	 * Gets the a3 flat.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the a3 flat
	 */
	private static char[] getA3Flat(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (char) 231;
			symbol[1] = (char) 103;
			symbol[2] = (char) 183;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 231;
			symbol[1] = (char) 103;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (char) 231;
			symbol[1] = (char) 87;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (char) 231;
			symbol[1] = (char) 119;
		}
		return symbol;
	}

	/**
	 * Gets the a3.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the a3
	 */
	private static char[] getA3(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 103;
			symbol[1] = (char) 183;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 103;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 87;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 119;
		}
		return symbol;
	}

	/**
	 * Gets the b3 flat.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the b3 flat
	 */
	private static char[] getB3Flat(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (char) 232;
			symbol[1] = (char) 104;
			symbol[2] = (char) 184;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 232;
			symbol[1] = (char) 104;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (char) 232;
			symbol[1] = (char) 88;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (char) 232;
			symbol[1] = (char) 120;
		}
		return symbol;
	}

	/**
	 * Gets the b3.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the b3
	 */
	private static char[] getB3(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 104;
			symbol[1] = (char) 184;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 104;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 88;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 120;
		}
		return symbol;
	}

	/**
	 * Gets the c3.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the c3
	 */
	private static char[] getC3(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 105;
			symbol[1] = (char) 185;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 105;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 89;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 121;
		}
		return symbol;
	}

	/**
	 * Gets the c3 sharp.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the c3 sharp
	 */
	private static char[] getC3Sharp(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (char) 217;
			symbol[1] = (char) 105;
			symbol[2] = (char) 185;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 217;
			symbol[1] = (char) 105;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (char) 217;
			symbol[1] = (char) 89;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (char) 217;
			symbol[1] = (char) 121;
		}
		return symbol;
	}

	/**
	 * Gets the d3.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the d3
	 */
	private static char[] getD3(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 106;
			symbol[1] = (char) 186;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 106;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 90;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 122;
		}
		return symbol;
	}

	/**
	 * Gets the e4 flat.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the e4 flat
	 */
	private static char[] getE4Flat(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (char) 235;
			symbol[1] = (char) 107;
			symbol[2] = (char) 187;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 235;
			symbol[1] = (char) 107;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (char) 235;
			symbol[1] = (char) 91;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (char) 235;
			symbol[1] = (char) 123;
		}
		return symbol;
	}

	/**
	 * Gets the e4.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the e4
	 */
	private static char[] getE4(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 107;
			symbol[1] = (char) 187;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 107;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 91;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 123;
		}
		return symbol;
	}

	/**
	 * Gets the f4.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the f4
	 */
	private static char[] getF4(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 108;
			symbol[1] = (char) 188;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 108;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 92;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 124;
		}
		return symbol;
	}

	/**
	 * Gets the f4 sharp.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the f4 sharp
	 */
	private static char[] getF4Sharp(Note note, char[] symbol) {
		note.setInMiddleBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (char) 220;
			symbol[1] = (char) 108;
			symbol[2] = (char) 188;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 220;
			symbol[1] = (char) 108;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (char) 220;
			symbol[1] = (char) 92;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (char) 220;
			symbol[1] = (char) 124;
		}
		return symbol;
	}

	/**
	 * Gets the g4.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the g4
	 */
	private static char[] getG4(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 99;
			symbol[1] = (char) 179;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 99;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 83;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 115;
		}
		return symbol;
	}

	/**
	 * Gets the a4 flat.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the a4 flat
	 */
	private static char[] getA4Flat(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (char) 228;
			symbol[1] = (char) 100;
			symbol[2] = (char) 180;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 228;
			symbol[1] = (char) 100;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (char) 228;
			symbol[1] = (char) 84;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (char) 228;
			symbol[1] = (char) 116;
		}
		return symbol;
	}

	/**
	 * Gets the a4.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the a4
	 */
	private static char[] getA4(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 100;
			symbol[1] = (char) 180;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 100;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 84;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 116;
		}
		return symbol;
	}

	/**
	 * Gets the b4 flat.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the b4 flat
	 */
	private static char[] getB4Flat(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (char) 229;
			symbol[1] = (char) 101;
			symbol[2] = (char) 181;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 229;
			symbol[1] = (char) 101;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (char) 229;
			symbol[1] = (char) 85;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (char) 229;
			symbol[1] = (char) 117;
		}
		return symbol;
	}

	/**
	 * Gets the b4.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the b4
	 */
	private static char[] getB4(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 101;
			symbol[1] = (char) 181;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 101;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 85;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 117;
		}
		return symbol;
	}

	/**
	 * Gets the c4.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the c4
	 */
	private static char[] getC4(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 102;
			symbol[1] = (char) 182;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 102;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 86;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 118;
		}
		return symbol;
	}

	/**
	 * Gets the c4 sharp.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the c4 sharp
	 */
	private static char[] getC4Sharp(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (char) 214;
			symbol[1] = (char) 102;
			symbol[2] = (char) 182;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 214;
			symbol[1] = (char) 102;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (char) 214;
			symbol[1] = (char) 86;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (char) 214;
			symbol[1] = (char) 118;
		}
		return symbol;
	}

	/**
	 * Gets the d4.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the d4
	 */
	private static char[] getD4(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 103;
			symbol[1] = (char) 183;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 103;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 87;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 119;
		}
		return symbol;
	}

	/**
	 * Gets the e5 flat.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the e5 flat
	 */
	private static char[] getE5Flat(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (char) 232;
			symbol[1] = (char) 104;
			symbol[2] = (char) 184;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 232;
			symbol[1] = (char) 104;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (char) 232;
			symbol[1] = (char) 88;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (char) 232;
			symbol[1] = (char) 120;
		}
		return symbol;
	}

	/**
	 * Gets the e5.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the e5
	 */
	private static char[] getE5(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 104;
			symbol[1] = (char) 184;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 104;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 88;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 120;
		}
		return symbol;
	}

	/**
	 * Gets the f5.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the f5
	 */
	private static char[] getF5(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 105;
			symbol[1] = (char) 185;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 105;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 89;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 121;
		}
		return symbol;
	}

	/**
	 * Gets the f5 sharp.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the f5 sharp
	 */
	private static char[] getF5Sharp(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (char) 217;
			symbol[1] = (char) 105;
			symbol[2] = (char) 185;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 217;
			symbol[1] = (char) 105;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (char) 217;
			symbol[1] = (char) 89;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (char) 217;
			symbol[1] = (char) 121;
		}
		return symbol;
	}

	/**
	 * Gets the g5.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the g5
	 */
	private static char[] getG5(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 106;
			symbol[1] = (char) 186;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 106;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 90;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 122;
		}
		return symbol;
	}

	/**
	 * Gets the a5 flat.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the a5 flat
	 */
	private static char[] getA5Flat(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (char) 235;
			symbol[1] = (char) 107;
			symbol[2] = (char) 187;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 235;
			symbol[1] = (char) 107;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (char) 235;
			symbol[1] = (char) 91;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (char) 235;
			symbol[1] = (char) 123;
		}
		return symbol;
	}

	/**
	 * Gets the a5.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the a5
	 */
	private static char[] getA5(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 107;
			symbol[1] = (char) 187;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 107;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 91;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 123;
		}
		return symbol;
	}

	/**
	 * Gets the b5 flat.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the b5 flat
	 */
	private static char[] getB5Flat(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[3];
			symbol[0] = (char) 236;
			symbol[1] = (char) 108;
			symbol[2] = (char) 188;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 236;
			symbol[1] = (char) 108;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[2];
			symbol[0] = (char) 236;
			symbol[1] = (char) 92;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[2];
			symbol[0] = (char) 236;
			symbol[1] = (char) 124;
		}
		return symbol;
	}

	/**
	 * Gets the b5.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the b5
	 */
	private static char[] getB5(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 108;
			symbol[1] = (char) 188;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 108;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 92;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 124;
		}
		return symbol;
	}

	/**
	 * Gets the c5.
	 * 
	 * @param note
	 *            the note
	 * @param symbol
	 *            the symbol
	 * @return the c5
	 */
	private static char[] getC5(Note note, char[] symbol) {
		note.setInUpperBar(true);
		String noteSymbol = note.getSymbol();
		if (noteSymbol.equals("1.5*Minim")) {
			symbol = new char[2];
			symbol[0] = (char) 109;
			symbol[1] = (char) 189;
		} else if (noteSymbol.equals("Minim")) {
			symbol = new char[1];
			symbol[0] = (char) 109;
		} else if (noteSymbol.equals("Crotchet")) {
			symbol = new char[1];
			symbol[0] = (char) 93;
		} else if (noteSymbol.equals("Semibreve")) {
			symbol = new char[1];
			symbol[0] = (char) 125;
		}
		return symbol;
	}
}
