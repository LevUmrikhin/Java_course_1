import type { NextConfig } from 'next';

const nextConfig: NextConfig = {
    async rewrites() {
        return [
            {
                source: '/api/:path*',  // Match all API routes
                destination: 'http://localhost:8080/api/:path*',  // Forward to Java backend
            },
        ];
    },
    /* other config options can go here */
};

export default nextConfig;
