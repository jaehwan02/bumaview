import { useState } from "react";

// .env로 부터 백엔드 URL 받아오기
const BACKEND_API_BASE_URL = import.meta.env.VITE_BACKEND_API_BASE_URL;

function LoginPage() {

    // .env로 부터 백엔드 URL 받아오기
    const BACKEND_API_BASE_URL = import.meta.env.VITE_BACKEND_API_BASE_URL;

    // 소셜 로그인 이벤트
    const handleSocialLogin = (provider) => {
        window.location.href = `${BACKEND_API_BASE_URL}/oauth2/authorization/${provider}`
    };

    // 페이지
    return (
        <div>
            <h1>BSSM 통합 로그인</h1>

            <div>
                <button onClick={() => handleSocialLogin("google")}>BSM 구글 계정으로 계속하기</button>
            </div>

        </div>
    );
}

export default LoginPage;