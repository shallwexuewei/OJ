public class Solution {
  
	public int compareVersion(String version1, String version2) {
		String[] vs1 = version1.split("\\.");
		String[] vs2 = version2.split("\\.");

		int num1 = Integer.parseInt(vs1[0]);
		int num2 = Integer.parseInt(vs2[0]);

		int i = 0;
		while (i < vs1.length || i < vs2.length) {
			if (i >= vs1.length) {
				num1 = 0;
			} else {
				num1 = Integer.parseInt(vs1[i]);
			}
			if (i >= vs2.length) {
				num2 = 0;
			} else {
				num2 = Integer.parseInt(vs2[i]);
			}

			if (num1 < num2) {
				return -1;
			} else if (num1 > num2) {
				return 1;
			} else {
				int fra1 = 0;
				int fra2 = 0;
				if (vs1.length > 1)
					fra1 = Integer.parseInt(vs1[1]);
				if (vs2.length > 1)
					fra2 = Integer.parseInt(vs2[1]);
				if (fra1 < fra2) {
					return -1;
				} else if (fra1 > fra2) {
					return 1;
				}
			}
			i++;
		}

		return 0;
	}
}
