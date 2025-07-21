import { useState } from 'react';
import { useUser } from '../../context/AuthContext';
import "./Navbar.css"

const Navbar = () => {
    const { user, users, login, logout } = useUser();
    const [selectedUserId, setSelectedUserId] = useState('');

    const handleUserChange = (e) => {
        e.preventDefault()
        const id = e.target.value;
        setSelectedUserId(id);

        const selectedUser = users.find(u => u.id === parseInt(id));
        if (selectedUser) login(selectedUser);
    }

    return (
        <div className="body">
            <div className="navbar">
                <div className="left"></div>
                <div className="center">
                    Course Enrollment & Review Platform
                </div>
                <div className="right">
                    {user ? (
                        <div>
                            {user.name}
                            <button onClick={() => {logout(); setSelectedUserId('')}} style={{ marginLeft: "10px" }}>
                                Logout
                            </button>
                        </div>
                    ) : (
                        <select onChange={handleUserChange} value={selectedUserId || ''}>
                            <option value="">Select user</option>
                            {users &&
                                users.map(temp => (
                                    <option value={temp.id} key={temp.id}>{temp.name}</option>
                                ))
                            }
                        </select>
                    )}
                </div>
            </div>
        </div>
    );
};

export default Navbar;