package atj;

public class TemperatureConverterService {
	
	public static Double Convert(String direction, Double temp) {
		switch (direction) {
		  case "C2F": return 32.0 + 9.0/5.0 * temp;  
		  case "F2C": return 5.0/9.0 * (temp - 32.0);
		  case "C2K": return temp + 273.15;
		  case "K2C": return temp - 273.15;
		}
		return 0.0;
	}
	
	public static enum ConvertionDirection {
		
		F2C("Faranhaite To Celsjus"), C2F("Celsjus to Franahite"), K2C("Kelvin to Celsjus"), C2K("Celsjus to Kelvin");
		
		private String desc;
		
		ConvertionDirection(String desc) {
			this.desc = desc;
		}
		
		public String getDesc() {
			return this.desc;
		}
	}
	

}
