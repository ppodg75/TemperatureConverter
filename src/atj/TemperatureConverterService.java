package atj;

public class TemperatureConverterService {
	
	public static Double Convert(String direction, Double temp) {
		
		
		return 100.0;
	}
	
	public static enum ConvertionDirection {
		
		F2C("Faranhaite To Celsjus"), C2F("Celsjus to Franahite");
		
		private String desc;
		
		ConvertionDirection(String desc) {
			this.desc = desc;
		}
		
		public String getDesc() {
			return this.desc;
		}
	}
	

}
