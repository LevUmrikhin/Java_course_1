import { GlobeAltIcon } from '@heroicons/react/24/outline';
import { Lato, Raleway } from 'next/font/google';

export const lato = Lato({
  weight: ['400', '700'],
  subsets: ['latin'],
});

export const raleway = Raleway({
  weight: ['400', '700'],
  subsets: ['latin'],
});


export default function AcmeLogo() {
  return (
    <div
        className={`${lato.className} antialiased flex flex-row items-center leading-none text-white`}
    >
      <GlobeAltIcon className="h-12 w-12 rotate-[15deg]" />
      <p className="text-[44px]">Lev Umrikhin</p>
    </div>
  );
}
