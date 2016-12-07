package tp2;

import java.util.Vector;

public class MainProgram {

	public static void main(String[] args) {
		
		Vector <Byte> v1 = new Vector<Byte>();
		v1.add((byte) 1);
		v1.add((byte) 0);
		v1.add((byte) 0);
		
		Vector <Byte> v2 = new Vector<Byte>();
		v2.add((byte) 0);
		v2.add((byte) 1);
		v2.add((byte) 0);
		
		Vector <Byte> v3 = new Vector<Byte>();
		v3.add((byte) 0);
		v3.add((byte) 0);
		v3.add((byte) 1);
		
		Vector <Byte> v4 = new Vector<Byte>();
		v4.add((byte) 1);
		v4.add((byte) 1);
		v4.add((byte) 0);
		
		Vector <Byte> v5 = new Vector<Byte>();
		v5.add((byte) 0);
		v5.add((byte) 1);
		v5.add((byte) 1);
		
		
		Vector <Byte> v6 = new Vector<Byte>();
		v6.add((byte) 1);
		v6.add((byte) 1);
		v6.add((byte) 1);
		
		Vector <Byte> v7 = new Vector<Byte>();
		v7.add((byte) 1);
		v7.add((byte) 0);
		v7.add((byte) 1);
		
		Vector<Vector<Byte>> matriceG =  new Vector<Vector<Byte>>();
		matriceG.add(v1);
		matriceG.add(v2);
		matriceG.add(v3);
		matriceG.add(v4);
		matriceG.add(v5);
		matriceG.add(v6);
		matriceG.add(v7);
		
		Detection detection = new Detection(matriceG);
		System.out.print("Matrice G               : ");
		System.out.println(matriceG);
		
		System.out.print("Les mots d'infos        : ");
		System.out.println(detection.getMotsInfo());
		
		System.out.print("Les mots codes          : ");
		System.out.println(detection.getMotsCode());
		
		System.out.print("La capacite de detection: ");
		System.out.println(detection.getCapaciteDetection());
	}

}
