package com.floremipy.user;

public enum UserType {
	Admin("Admin"), 
	User("User");
	private final String text;

    /**
     * @param text
     */
    private UserType(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
