import axios from 'axios';
const API_URL = 'http://localhost:8080/api';

export const registrarT = (userId, dispositivo) => axios.post(`${API_URL}/usuarios/${userId}/termostatos`, dispositivo);
export const obtenerT = (userId) => axios.get(`${API_URL}/usuarios/${userId}/termostatos`);