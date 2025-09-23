import React, { useState } from 'react';
import axios from 'axios';
import './App.css'; // We will create this file for styling

function App() {
    const [regNo, setRegNo] = useState('');
    const [result, setResult] = useState(null);
    const [error, setError] = useState('');

    const handleSearch = async () => {
        try {
            setError('');
            setResult(null);
            const response = await axios.get(`http://localhost:8080/api/results/${regNo}`);
            setResult(response.data);
        } catch (err) {
            setError('Result not found. Please check the registration number.');
            setResult(null);
        }
    };

    return (
        <div className="container">
            <header>
                <h1>VIT Semester Result</h1>
            </header>
            <main>
                <div className="search-box">
                    <input
                        type="text"
                        value={regNo}
                        onChange={(e) => setRegNo(e.target.value.toUpperCase())}
                        placeholder="Enter Registration Number"
                    />
                    <button onClick={handleSearch}>Search</button>
                </div>

                {error && <p className="error-message">{error}</p>}

                {result && (
                    <div className="result-card">
                        <h2>Result for: {result.studentName} ({result.regNo})</h2>
                        <table>
                            <thead>
                                <tr>
                                    <th>Subject</th>
                                    <th>Final Marks (100)</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td> Linear Algebra</td>
                                    <td>{result.sub1_total.toFixed(2)}</td>
                                </tr>
                                <tr>
                                    <td>Data Structures & Algorithms</td>
                                    <td>{result.sub2_total.toFixed(2)}</td>
                                </tr>
                                <tr>
                                    <td>Computer Networks</td>
                                    <td>{result.sub3_total.toFixed(2)}</td>
                                </tr>
                                <tr>
                                    <td>Object Oriented Programming</td>
                                    <td>{result.sub4_total.toFixed(2)}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                )}
            </main>
        </div>
    );
}

export default App;