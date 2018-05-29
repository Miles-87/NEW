function fetchData() {
    return fetch('http://localhost:9090/teams')
        .then(response => response.json())
};

export default fetchData;