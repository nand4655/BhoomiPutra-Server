package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class FarmersAsset implements Serializable
{
		// TODO Auto-generated constructor stub
		double totalLand;
		String maincrops;
		Cattles animal;
		ArrayList<String> maincrop;
		
		
		public FarmersAsset(double totalLand, String maincrops, Cattles animal,ArrayList<String> maincrop) {
			super();
			this.totalLand = totalLand;
			this.maincrops = maincrops;
			this.animal = animal;
			this.maincrop=maincrop;
			
		}
		public ArrayList<String> getMaincrop() {
			return maincrop;
		}
		public void setMaincrop(ArrayList<String> maincrop) {
			this.maincrop = maincrop;
		}
		public double getTotalLand() {
			return totalLand;
		}
		public void setTotalLand(double totalLand) {
			this.totalLand = totalLand;
		}
		public String getMaincrops() {
			return maincrops;
		}
		public void setMaincrops(String maincrops) {
			this.maincrops = maincrops;
		}
		public Cattles getAnimal() {
			return animal;
		}
		public void setAnimal(Cattles animal) {
			this.animal = animal;
		}
		@Override
		public String toString() {
			return "FarmersAsset [totalLand=" + totalLand + ", maincrops="
					+ maincrops + ", animal=" + animal + ", maincrop="
					+ maincrop + "]";
		}
	
	
		}
		
		
	

