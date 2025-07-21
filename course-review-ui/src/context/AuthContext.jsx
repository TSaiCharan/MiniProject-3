import { createContext, useContext, useEffect, useState } from "react";

import useApi from "../hooks/useApi"

export const AuthContext = createContext();

const AuthProvider = ({ children }) => {
    const users = useApi("/users");
    const [user, setUser] = useState(null);

    const login = (user) => setUser(user);
    const logout = () => setUser(null);

    return (
        <AuthContext.Provider value={{ user, setUser, users, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useUser = () => {
  const context = useContext(AuthContext);
  if (context === undefined) {
    throw new Error("useUser must be used within a TaskProvider");
  }
  return context;
};

export default AuthProvider ;
