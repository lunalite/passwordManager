/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager.models;

/**
 *
 * @author HD
 */
public enum ACC_TYPE {
    SERVICE("service", "Please enter the type of service: "),
    USERNAME("username", "Please enter your username: "),
    PASSWORD("password", "Please enter your current password: "),
    EMAIL("email", "Please enter the registered email: "),
    MISC("misc", "Are there any other details required?: ");

    private final String _stringRep;
    private final String _query;

    private ACC_TYPE(final String stringRep, final String query) {
        this._stringRep = stringRep;
        this._query = query;
    }

    @Override
    public String toString() {
        return this._stringRep;
    }

    public String toQuery() {
        return this._query;
    }
}
