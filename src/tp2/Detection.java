package tp2;

import java.security.InvalidParameterException;
import java.util.Vector;


/**
 *
 * @author Ayoubo
 * @date 6 Dec 2016
 */
public class Detection {
	
	/**
	 * @param matriceG
	 */
	public Detection (Vector<Vector<Byte>> matriceG) {
		
		if (matriceG == null || matriceG.size() == 0 || matriceG.get(0).size() == 0)
			throw new InvalidParameterException("Matrice non valide");
		
		this.matriceG   = matriceG;
		this.nbrColonne = matriceG.size();
		this.nbrLigne   = matriceG.get(0).size();
		this.motsInfo   = this.ensembleMotsInfo();
		this.motsCode   = this.ensembleMotsCode();
		this.capaciteDetection = this.capaciteDetection();
	}
	
	
	/**
	 * @return
	 */
	private Vector<Vector<Byte>> ensembleMotsInfo () {
		
		Vector<Vector<Byte>> motsInfo = new Vector<Vector<Byte>>();
		String               s        = null;
		byte                 b;
		
		for (int i = 0; i < Math.pow(2, nbrLigne); i++) {
			
			Vector <Byte> v = new Vector<Byte>();
			StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));
			
	        for(int j = sb.length(); j < nbrLigne; j++) {
	            sb.insert( 0, '0' );
	        }
	        
	        s = sb.toString();
	        
	        for(int k=0; k<nbrLigne; k++) {
	        	b = (byte)(s.charAt(k) - (int)('0'));
	        	v.add(b);
	        }
	        motsInfo.add(v);
		}
		return motsInfo;
	}
	
	
	/**
	 * @return
	 */
	private Vector<Vector<Byte>> ensembleMotsCode () {
		Vector<Vector<Byte>> motsCode = new Vector<Vector<Byte>>();	
			
			for (int j=0; j<motsInfo.size(); j++) { // 8
				Vector<Byte> vr = new Vector<Byte>();
				Vector<Byte> v1 = motsInfo.get(j);
				
				for (int k=0; k<nbrColonne; k++) { //3
					 Vector<Byte> v2 = matriceG.get(k);
					 
					 byte br = 0;
					 
					 for (int i=0; i<nbrLigne; i++) {
					 	 br = (byte) ((br + (v1.get(i) * v2.get(i)))%2);
					 }
					 vr.add(br);
				}
				motsCode.add(vr);
			}
		return motsCode;
	}
	
	
	
	private int capaciteDetection () {
		int capaciteDetection = Integer.MAX_VALUE;
		Vector<Byte> v1 = new Vector<Byte>();
		Vector<Byte> v2 = new Vector<Byte>();
		
		for(int i=0; i<motsCode.size(); i++) {
			v1 = motsCode.get(i);
			for(int j=i+1; j<motsCode.size(); j++) {
				v2 = motsCode.get(j);
				int result = 0;
				for(int k=0; k<motsCode.get(0).size(); k++) {
					if (v1.get(k) != v2.get(k)) {
							result++;
					}
				}
				if (result < capaciteDetection)
					capaciteDetection = result - 1;
			}
		}
		return capaciteDetection;
	}
	
	
	
	/**
	 * @return
	 */
	public Vector<Vector<Byte>> getMotsInfo () {
		return motsInfo;
	}
	
	
	/**
	 * @return
	 */
	public Vector<Vector<Byte>> getMotsCode() {
		return motsCode;
	}
	

	/**
	 * @return
	 */
	public int getCapaciteDetection() {
		return capaciteDetection;
	}



	private Vector<Vector<Byte>> matriceG;
	private final int            nbrLigne;
	private final int            nbrColonne;
	private Vector<Vector<Byte>> motsInfo;
	private Vector<Vector<Byte>> motsCode; 
	private int                  capaciteDetection;
}

