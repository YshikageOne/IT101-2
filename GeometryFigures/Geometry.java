package GeometryFigures;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class Geometry {
	
	public static void main(String[] args) {
		//input
		String shapeMenu = ("-----Choose your shape------" + 
				        "\n[A] Square/Cube" +
				        "\n[B] Triangle/Pyramid" + 
				        "\n[C] Rectangle/Rectangular Prism" +
				        "\n[D] Trapezoid/Trapezoidal Prism" +
				        "\n[E] Circle/Sphere");
		
		String shape = JOptionPane.showInputDialog(null, shapeMenu, "Choose your shape", JOptionPane.PLAIN_MESSAGE);
		
		try {
			if(shape == null) {
				System.exit(0);
			}else {
				switch(shape.toLowerCase()) {
				case "a":
					JOptionPane.showMessageDialog(null, square(operations()), "Square!!", JOptionPane.INFORMATION_MESSAGE);
					break;
				case "b":
					JOptionPane.showMessageDialog(null, triangle(operations()), "Triangle!!", JOptionPane.INFORMATION_MESSAGE);
					break;
				case "c":
					JOptionPane.showMessageDialog(null, rectangle(operations()), "Rectangle!!", JOptionPane.INFORMATION_MESSAGE);
					break;
				case "d":
					JOptionPane.showMessageDialog(null, trapezoid(operations()), "Trapezoid!!", JOptionPane.INFORMATION_MESSAGE);
					break;
				case "e":
					JOptionPane.showMessageDialog(null, circle(operations()), "Circle!!", JOptionPane.INFORMATION_MESSAGE);
					break;
				default:
					 JOptionPane.showMessageDialog(null, "Invalid input. Please enter A, B, C, D, or E.", "Error", JOptionPane.ERROR_MESSAGE);
					 break;
				}
			}
		} catch(NullPointerException e) {
			main(args);
		}
	}
	
	//input for what to do get for the shape
	public static String operations() {
		String operationMenu = ("-----Choose------" + 
		        "\n[A] Perimeter / Circumference(FOR CIRCLE)" +
		        "\n[B] Area" + 
		        "\n[C] Volume");
		
		String operation = JOptionPane.showInputDialog(null, operationMenu, "Choose your operation", JOptionPane.PLAIN_MESSAGE);
		try {
			if(operation == null) {
				return null;
			} else {
				return operation.toLowerCase();
			}
		} catch(NullPointerException e) {
			return null;
		}
	} 
	
	//shapes
	public static String square(String choice) {
		switch(choice) {
		case "a": //perimeter
			double side = Double.parseDouble(JOptionPane.showInputDialog(null, "What's the length of the sides?", "Perimeter", JOptionPane.PLAIN_MESSAGE));
			
			double perimeter = 4 * side;
			String perString = ("The perimeter of a square with side length " + side + " is " + String.format("%.2f", perimeter));
			return perString;
		case "b": //area
			double sideArea = Double.parseDouble(JOptionPane.showInputDialog(null, "What's the length of the sides?", "Area", JOptionPane.PLAIN_MESSAGE));
			
			double area = sideArea * sideArea;
			String areaString = ("The area of a square with side length " + sideArea + " is " + String.format("%.2f", area));
			return areaString;
		case "c": //volume
			double edges = Double.parseDouble(JOptionPane.showInputDialog(null, "What's the length of the edges?", "Volume", JOptionPane.PLAIN_MESSAGE));
			
			double volume = edges * edges * edges;
			String volString = ("The volume of a cube with edge length " + edges + " is " + String.format("%.2f", volume));
			return volString;
        default: // invalid choice
            throw new IllegalArgumentException("Invalid choice: " + choice);

		}
	}
	
	public static String triangle(String choice) {
		switch(choice) {
		case "a": //perimeter
			JPanel layout1 = new JPanel(new GridLayout(3,2));
			
			JTextField side1 = new JTextField();
			JTextField side2 = new JTextField();
			JTextField side3 = new JTextField();
			layout1.add(new JLabel("Enter the length of the first side:"));
			layout1.add(side1);
			
			layout1.add(new JLabel("Enter the length of the second side:"));
			layout1.add(side2);
			
			layout1.add(new JLabel("Enter the length of the third side:"));
			layout1.add(side3);
			
			int x = JOptionPane.showConfirmDialog(null, layout1, "Perimeter", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(x == JOptionPane.OK_OPTION) {
				double a, b, c;
				a = Double.parseDouble(side1.getText());
				b = Double.parseDouble(side2.getText());
				c = Double.parseDouble(side3.getText());
				
				double perimeter = a + b + c;
				String perString = ("The perimeter of a triangle with side lengths " + a + ", " + b + " and " + c + " is " + String.format("%.2f", perimeter));
				return perString;
			}
		
		case "b":
            JPanel layout2 = new JPanel(new GridLayout(2,2));
			
			JTextField base = new JTextField();
			JTextField height = new JTextField();
			
			layout2.add(new JLabel("Enter the length of the base:"));
			layout2.add(base);
			
			layout2.add(new JLabel("Enter the length of the height:"));
			layout2.add(height);
			
			int y = JOptionPane.showConfirmDialog(null, layout2, "Area", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(y == JOptionPane.OK_OPTION) {
				double b, h;
				b = Double.parseDouble(base.getText());
				h = Double.parseDouble(height.getText());
				
				double area = ((h * b)/2);
				String areaString = ("The area of a triangle with the base length of " + b + " and the height length of " + h + " is " +  String.format("%.2f", area));
				return areaString;
			}
			
		case "c":
            JPanel layout3 = new JPanel(new GridLayout(3,2));
			
			JTextField length = new JTextField();
			JTextField width = new JTextField();
			JTextField pyHeight = new JTextField();
			layout3.add(new JLabel("Enter the length of the pyramid:"));
			layout3.add(length);
			
			layout3.add(new JLabel("Enter the width of the pyramid:"));
			layout3.add(width);
			
			layout3.add(new JLabel("Enter the height of the pyramid:"));
			layout3.add(pyHeight);
			
			int z = JOptionPane.showConfirmDialog(null, layout3, "Volume", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(z == JOptionPane.OK_OPTION) {
				double l, w, h;
				l = Double.parseDouble(length.getText());
				w = Double.parseDouble(width.getText());
				h = Double.parseDouble(pyHeight.getText());
				
				double volume = ((l * w * h)/3);
				String volString = ("The volume of a pyramid with length " + l + ", with width " + w + ", and with height " + h + " is " + String.format("%.2f", volume));
				return volString;
			}
			
		default: // invalid choice
            throw new IllegalArgumentException("Invalid choice: " + choice);
		}
	}
	
	public static String rectangle(String choice) {
		switch(choice) {
		case "a": //perimeter
			JPanel layout1 = new JPanel(new GridLayout(2,2));
			
			JTextField perLength = new JTextField();
			JTextField perWidth = new JTextField();
			
			layout1.add(new JLabel("Enter the length of the rectangle:"));
			layout1.add(perLength);
			layout1.add(new JLabel("Enter the width of the rectangle:"));
			layout1.add(perWidth);
			
			int x = JOptionPane.showConfirmDialog(null, layout1, "Perimeter", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(x == JOptionPane.OK_OPTION) {
				double l, w;
				l = Double.parseDouble(perLength.getText());
				w = Double.parseDouble(perWidth.getText());
				
				double perimeter = ((l + w) * 2);
				String perString = ("The perimeter of a rectangle with length " + l + " and with width " + w + " is " + String.format("%.2f", perimeter));
				return perString;	
			}
			
		case "b":
            JPanel layout2 = new JPanel(new GridLayout(2,2));
			
			JTextField areaLength = new JTextField();
			JTextField areaWidth = new JTextField();
			
			layout2.add(new JLabel("Enter the length of the rectangle:"));
			layout2.add(areaLength);
			layout2.add(new JLabel("Enter the width of the rectangle:"));
			layout2.add(areaWidth);
			
			int y = JOptionPane.showConfirmDialog(null, layout2, "Area", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(y == JOptionPane.OK_OPTION) {
				double l, w;
				l = Double.parseDouble(areaLength.getText());
				w = Double.parseDouble(areaWidth.getText());
				
				double area = (l * w);
				String areaString = ("The area of a rectangle with length " + l + " and with width " + w + " is " + String.format("%.2f", area));
				return areaString;	
			}
		
		case "c":
            JPanel layout3 = new JPanel(new GridLayout(3,2));
			
			JTextField volLength = new JTextField();
			JTextField volWidth = new JTextField();
			JTextField volHeight = new JTextField();
			
			layout3.add(new JLabel("Enter the length of the rectangle:"));
			layout3.add(volLength);
			layout3.add(new JLabel("Enter the width of the rectangle:"));
			layout3.add(volWidth);
			layout3.add(new JLabel("Enter the height of the rectangle:"));
			layout3.add(volHeight);
			
			int z = JOptionPane.showConfirmDialog(null, layout3, "Volume", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(z == JOptionPane.OK_OPTION) {
				double l, w, h;
				l = Double.parseDouble(volLength.getText());
				w = Double.parseDouble(volWidth.getText());
				h = Double.parseDouble(volHeight.getText());
				
				double volume = (l * w * h);
				String volString = ("The volume of a rectangular prism with length " + l + ", width " + w + " and height " + h + " is " + String.format("%.2f", volume));
				return volString;	
			}
			
		default: // invalid choice
            throw new IllegalArgumentException("Invalid choice: " + choice);	
		}
	}
	
	public static String trapezoid(String choice) {
		switch(choice) {
		case "a":
			JPanel layout1 = new JPanel(new GridLayout(4,2));
				
			JTextField side1 = new JTextField();
			JTextField side2 = new JTextField();
			JTextField side3 = new JTextField();
			JTextField side4 = new JTextField();
				
			layout1.add(new JLabel("Enter the first side of the trapezoid:"));
			layout1.add(side1);
			layout1.add(new JLabel("Enter the second side of the trapezoid:"));
			layout1.add(side2);
			layout1.add(new JLabel("Enter the third side of the trapezoid:"));
			layout1.add(side3);
			layout1.add(new JLabel("Enter the forth side of the trapezoid:"));
			layout1.add(side4);
			

			int x = JOptionPane.showConfirmDialog(null, layout1, "Perimeter", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(x == JOptionPane.OK_OPTION) {
				double a,b,c,d;
				a = Double.parseDouble(side1.getText());
				b = Double.parseDouble(side2.getText());
				c = Double.parseDouble(side3.getText());
				d = Double.parseDouble(side4.getText());
				
				double perimeter = (a+b+c+d);
				String perString = ("The perimeter of the trapezoid with lengths " + a + ", " + b + ", " + c + ", " + d + " is " + String.format("%.2f", perimeter));
				return perString;	
			}
		
		case "b":
			JPanel layout2 = new JPanel(new GridLayout(3,2));
			
			JTextField topBase = new JTextField();
			JTextField bottomBase = new JTextField();
			JTextField height = new JTextField();
			
			layout2.add(new JLabel("Enter the top base of the trapezoid:"));
			layout2.add(topBase);
			layout2.add(new JLabel("Enter the bottom base of the trapezoid:"));
			layout2.add(bottomBase);
			layout2.add(new JLabel("Enter the height of the trapezoid:"));
			layout2.add(height);
			
			int y = JOptionPane.showConfirmDialog(null, layout2, "Area", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(y == JOptionPane.OK_OPTION) {
				double a,b,h;
				a = Double.parseDouble(topBase.getText());
				b = Double.parseDouble(bottomBase.getText());
				h = Double.parseDouble(height.getText());
				
				double area = (((a+b)/2) * h);
				String areaString = ("The area of the trapezoid with lengths " + a + ", " + b + " and height " + h +" is " + String.format("%.2f", area));
				return areaString;	
			}
			
		case "c":
			JPanel layout3 = new JPanel(new GridLayout(4,2));
			
			JTextField shortBase = new JTextField();
			JTextField longBase = new JTextField();
			JTextField length = new JTextField();
			JTextField volHeight = new JTextField();
				
			layout3.add(new JLabel("Enter the top base of the trapezoidal prism:"));
			layout3.add(shortBase);
			layout3.add(new JLabel("Enter the bottom base of the trapezoidal prism:"));
			layout3.add(longBase);
			layout3.add(new JLabel("Enter the length of the trapezoidal prism:"));
			layout3.add(length);
			layout3.add(new JLabel("Enter the height of the trapezoidal prism:"));
			layout3.add(volHeight);
			
			int z = JOptionPane.showConfirmDialog(null, layout3, "Volume", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(z == JOptionPane.OK_OPTION) {
				double a,b,h,l;
				a = Double.parseDouble(shortBase.getText());
				b = Double.parseDouble(longBase.getText());
				h = Double.parseDouble(volHeight.getText());
				l = Double.parseDouble(length.getText());
				
				double volume = (((a + b)/2) * h * l);
				String volString = ("The volume of the trapezoidal prism with short base " + a + ", long base " + b + ", height " + h + ", and length " + l +" is " + String.format("%.2f", volume));
				return volString;	
			}
		default: // invalid choice
            throw new IllegalArgumentException("Invalid choice: " + choice);	
		}
	}
	
	public static String circle(String choice) {
		switch(choice) {
		case "a":
			double perRadius = Double.parseDouble(JOptionPane.showInputDialog(null, "What's the radius of the circle?", "Circumference", JOptionPane.PLAIN_MESSAGE));
			
			double circumference = (2 * Math.PI * perRadius);
			String perString = ("The circumference of a circle with radius " + perRadius + " is " + String.format("%.2f", circumference));
			return perString;
		
		case "b":
			double areaRadius = Double.parseDouble(JOptionPane.showInputDialog(null, "What's the radius of the circle?", "Area", JOptionPane.PLAIN_MESSAGE));
			
			double area = (Math.PI * (areaRadius * areaRadius));
			String areaString = ("The area of a circle with radius " + areaRadius + " is " + String.format("%.2f", area));
			return areaString;
		
		case "c":
			double volRadius = Double.parseDouble(JOptionPane.showInputDialog(null, "What's the radius of the circle?", "Volume", JOptionPane.PLAIN_MESSAGE));
			
			double volume = ((4 * Math.PI * (volRadius * volRadius * volRadius))/3);
			String volString = ("The volume of a sphere with radius " + volRadius + " is " + String.format("%.2f", volume));
			return volString;
			
		default: // invalid choice
            throw new IllegalArgumentException("Invalid choice: " + choice);	
		}
	}

}
