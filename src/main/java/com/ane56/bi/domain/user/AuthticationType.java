package com.ane56.bi.domain.user;

public enum AuthticationType {

	USERNAME {
		@Override
		public boolean isUsername() {
			return true;
		}
	},
	NUMBER {
		@Override
		public boolean isNumber() {
			return true;
		}
	},
	PHONE_NUMBER {
		@Override
		public boolean isPhoneNumber() {
			return true;
		}
	},
	EMAIL {
		@Override
		public boolean isEmail() {
			return true;
		}
	};

	public boolean isUsername() {
		return false;
	}

	public boolean isNumber() {
		return false;
	}

	public boolean isPhoneNumber() {
		return false;
	}

	public boolean isEmail() {
		return false;
	}

}
