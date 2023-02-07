package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 * @author Sarthak Shah
 */

public class JnzInstruction extends Instruction {
	private final RegisterName source;

	public static final String OP_CODE = "jnz";

	private final String jmpLabel;

	public JnzInstruction(String label, RegisterName source, String jmpLabel) {
		super(label, OP_CODE);
		this.source = source;
		this.jmpLabel = jmpLabel;
	}

	@Override
	public int execute(Machine m) {
		int value = m.getRegisters().get(this.source);
		if(value == 0) {
			return NORMAL_PROGRAM_COUNTER_UPDATE;
		}
		return (m.getLabels().getAddress(this.jmpLabel));
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + source;
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof JnzInstruction){
			JnzInstruction otherInstruction = (JnzInstruction) o;
			return Objects.equals(this.label, otherInstruction.label)
					&& Objects.equals(this.opcode, otherInstruction.opcode)
					&& Objects.equals(this.source, otherInstruction.source);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.label,this.opcode,this.source);
	}
}
