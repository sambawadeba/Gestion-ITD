import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 7954,
  login: 'EioK',
};

export const sampleWithPartialData: IUser = {
  id: 13461,
  login: 'q',
};

export const sampleWithFullData: IUser = {
  id: 4183,
  login: 'r',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
