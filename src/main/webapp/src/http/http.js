import axios from 'axios'
import store from "@/store";
const baseUrl = 'http://localhost:7800/'

const http = axios.create({
    baseURL: baseUrl,
    headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    }
});

http.interceptors.request.use(
    config => {
        const token = store.getters.getToken;
        if (token) {
            config.headers['Authorization'] = `Bearer ${token}`;
        }
        return config;
    }
);

export default http