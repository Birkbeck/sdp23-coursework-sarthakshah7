package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 * @author Sarthak Shah
 */

public class MovInstruction extends Instruction {
	private final RegisterName result;
	private final String source;

	public static final String OP_CODE = "mov";

	public MovInstruction(String label, RegisterName result, String source) {
		super(label, OP_CODE);
		this.result = result;
		this.source = source;
	}

	@Override
	public int execute(Machine m) {
		int value2 = Integer.valueOf(source);
		m.getRegisters().set(result, value2);
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result + " " + source;
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof  MovInstruction){
			MovInstruction otherInstruction = (MovInstruction) o;
			return Objects.equals(this.label, otherInstruction.label)
					&& Objects.equals(this.opcode, otherInstruction.opcode)
					&& Objects.equals(this.source, otherInstruction.source)
					&& Objects.equals(this.result, otherInstruction.result);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.label,this.opcode,this.source,this.result);
	}
}
