import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '8661d613-83bc-4721-9944-e828ad78f149',
};

export const sampleWithPartialData: IAuthority = {
  name: '6d0a089e-058a-4c85-aec0-da8ab602fdfe',
};

export const sampleWithFullData: IAuthority = {
  name: '7cdab1d4-6dcf-4a60-b11b-a5b30bba2d76',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
