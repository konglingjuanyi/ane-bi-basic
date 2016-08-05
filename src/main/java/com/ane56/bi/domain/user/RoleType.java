package com.ane56.bi.domain.user;

public enum RoleType {

	DEFAULT {
		@Override
		public boolean isDefault() {
			return true;
		}
	},
	ADMIN {
		@Override
		public boolean isAdmin() {
			return true;
		}
	};

	public boolean isDefault() {
		return false;
	}

	public boolean isAdmin() {
		return false;
	}

}
