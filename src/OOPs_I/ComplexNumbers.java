package OOPs_I;
import java.util.*;

public class ComplexNumbers {
    int real;
    int imaginary;

    ComplexNumbers(int real, int imaginary){
      this.real = real;
      this.imaginary = imaginary;
    }

    void plus(ComplexNumbers c2){
      this.real = this.real + c2.real;
      this.imaginary = this.imaginary + c2.imaginary;
    }

    void print(){
      System.out.print(this.real + " + " + "i" + this.imaginary);
    }

    void multiply(ComplexNumbers c2){
      int temp = this.real;
      this.real = this.real * c2.real + (-1) * this.imaginary * c2.imaginary;
      this.imaginary = (temp * c2.imaginary) + (c2.real * this.imaginary);
    }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int real1 = 3;//s.nextInt();
    int imaginary1 = 6;//s.nextInt();

    int real2 = 7;//s.nextInt();
    int imaginary2 = 9;//s.nextInt();

    ComplexNumbers c1 = new ComplexNumbers(real1, imaginary1);
    ComplexNumbers c2 = new ComplexNumbers(real2, imaginary2);

    System.out.print("Enter your choice: ");
    int choice = s.nextInt();

    if(choice == 1) {
      // Add
      c1.plus(c2);
      c1.print();
    }
    else if(choice == 2) {
      // Multiply
      c1.multiply(c2);
      c1.print();
    }
  }
}
