import axios from 'axios';
const API_URL = 'http://localhost:8080/api/termostatos';

export const registrarT = (dispositivo) => axios.post(API_URL, dispositivo);
export const obtenerT = () => axios.get(API_URL);
