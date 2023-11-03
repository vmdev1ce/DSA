import java.util.ArrayList;
import java.util.List;

public class FormulaEval {
	public String toString(String[] parts, int start, int end) {
		String rez = "";
		for (int i = start; i < end; i++) {
			if (i >= parts.length) {
				continue;
			}
			rez = rez.concat(parts[i]).concat(",");
		}
		return rez;
	}

	public double eval(String fomular) {
		String[] parts = fomular.split(" ");
		return eval(parts, 0, parts.length);
	}

	class Out {
		public Out(double value, int index) {
			this.value = value;
			this.index = index;
		}

		double value;
		int index;
	}

	private double eval(String[] parts, int start, int end) {
		Out out = recusiveEval(parts, start, end);
		return out.value;
	}

	class Equation {
		public Equation() {
			numbers = new ArrayList<Double>();
			operators = new ArrayList<String>();
		}

		List<Double> numbers;
		List<String> operators;

		@Override
		public String toString() {
			return "Equation [numbers=" + numbers + ", operators=" + operators + "]";
		}

		public double cal() {
			Equation eq = new Equation();
			double num01 = this.numbers.get(0);
			for (int idN = 1; idN < this.numbers.size(); idN++) {
				String operator = this.operators.get(idN - 1);
				double num02 = this.numbers.get(idN);
				if (operator.compareTo("*") == 0) {
					num01 *= num02;
				} else if (operator.compareTo("/") == 0) {
					num01 /= num02;
				} else {
					eq.addNumber(num01);
					eq.addOperator(operator);
					num01 = num02;
				}
			}
			eq.addNumber(num01);
			return eq.calOnlyAddSub();
		}

		private double calOnlyAddSub() {
			double value = this.numbers.get(0);
			for (int idN = 1; idN < this.numbers.size(); idN++) {
				String operator = this.operators.get(idN - 1);
				double num02 = this.numbers.get(idN);
				if (operator.compareTo("+") == 0) {
					value += num02;
				} else {
					value -= num02;
				}
			}
			return value;
		}

		public void addNumber(double number) {
			this.numbers.add(number);
		}

		public void addOperator(String operator) {
			this.operators.add(operator);
		}

	}

	private Out recusiveEval(String[] parts, int start, int end) {
		Equation equation = new Equation();
		int i = start;
		while (i < end) {
			if (parts[i].compareTo("(") == 0) {
				Out out = recusiveEval(parts, i + 1, end);
				equation.addNumber(out.value);
				i = out.index + 1;
				continue;
			}
			if (parts[i].compareTo(")") == 0) {
				return new Out(equation.cal(), i);
			}
			if (isOperator(parts[i])) {
				equation.addOperator(parts[i]);
			} else {
				double number = Double.parseDouble(parts[i]);
				equation.addNumber(number);
			}
			i++;
		}
		return new Out(equation.cal(), end);
	}

	public boolean isOperator(String str) {
		if (str.compareTo("+") == 0) {
			return true;
		}
		if (str.compareTo("-") == 0) {
			return true;
		}
		if (str.compareTo("*") == 0) {
			return true;
		}
		if (str.compareTo("/") == 0) {
			return true;
		}
		return false;
	}
}
