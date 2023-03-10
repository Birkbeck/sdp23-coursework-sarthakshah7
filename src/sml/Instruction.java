package sml;

// TODO: write a JavaDoc for the class

/**
 * Represents an abstract instruction.
 * @description It is a blue-print of an instruction to be executed by the interpreter.
 * @author Sarthak Shah
 * @modified_date 02/March/2023
 */
public abstract class Instruction {
	protected final String label;
	protected final String opcode;
	//protected final String comment;
	/**
	 * Constructor: an instruction with a label and an opcode
	 * (opcode must be an operation of the language)
	 *
	 * @param label optional label (can be null)
	 * @param opcode operation name
	 */
	public Instruction(String label, String opcode) {
		this.label = label;
		this.opcode = opcode;
	}

	public String getLabel() {
		return label;
	}

	public String getOpcode() {
		return opcode;
	}

	public static int NORMAL_PROGRAM_COUNTER_UPDATE = -1;

	/**
	 * Executes the instruction in the given machine.
	 *
	 * @param machine the machine the instruction runs on
	 * @return the new program counter (for jump instructions)
	 *          or NORMAL_PROGRAM_COUNTER_UPDATE to indicate that
	 *          the instruction with the next address is to be executed
	 */

	public abstract int execute(Machine machine);

	protected String getLabelString() {
		return (getLabel() == null) ? "" : getLabel() + ": ";
	}

	// TODO: What does abstract in the declaration below mean?
	//       (Write a short explanation.)
	/**
	 *
	 * The methods declared as abstract are supposed to be implemented by all its subclasses.
	 * It will force all the subclasses to define the execution steps in it.
	 */

	@Override
	public abstract String toString();

	// TODO: Make sure that subclasses also implement equals and hashCode (needed in class Machine).
	@Override
	public abstract boolean equals(Object o);

	@Override
	public abstract int hashCode();
}
